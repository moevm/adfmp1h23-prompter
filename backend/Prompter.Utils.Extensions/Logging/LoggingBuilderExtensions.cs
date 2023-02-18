using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using Serilog;
using Serilog.Core;

namespace Prompter.Utils.Extensions.Logging;

public static class LoggingBuilderExtensions
{
    public static void AddSerilog(this WebApplicationBuilder builder) {
        builder.Logging.AddSerilog(builder.Configuration);
    }

    public static IHostBuilder AddSerilog(this IHostBuilder builder) {
        builder.ConfigureLogging((ctx, loggingBuilder) => {
            loggingBuilder.AddSerilog(ctx.Configuration);
        });
        return builder;
    }

    private static void AddSerilog(this ILoggingBuilder logger, IConfiguration configuration) {
        logger.ClearProviders();
        logger.AddSerilog(CreateLogger(configuration));
    }

    private static Logger CreateLogger(IConfiguration configuration) {
        return new LoggerConfiguration()
            .ReadFrom.Configuration(configuration)
            .Enrich.FromLogContext()
            .CreateLogger();
    }
}