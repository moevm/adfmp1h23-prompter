using Microsoft.OpenApi.Models;
using Prompter.Utils.Extensions.Logging;

var builder = WebApplication.CreateBuilder(args);

builder.Host.ConfigureAppConfiguration((_, config) => 
{
    config.AddEnvironmentVariables();
});

builder.Services.AddEndpointsApiExplorer();
builder.Services.AddControllers();
builder.Services.AddSwaggerGen(options => {
    options.SwaggerDoc("v1", new OpenApiInfo() 
    {
        Title = "PROMPTER API",
        Version = "v1",
    });
});
builder.AddSerilog();


var app = builder.Build();

app.UseSwagger(c => {
    c.RouteTemplate = "/api/swagger/{documentName}/swagger.json";
});
app.UseSwaggerUI(c => {
    c.SwaggerEndpoint("/api/swagger/v1/swagger.json",
        "PROMPTER API v1");
    c.RoutePrefix = "api/swagger";
});


app.MapControllers();
app.Run();