using Microsoft.AspNetCore.Mvc;

namespace Prompter.Apps.Backend.Controllers;

/// <summary>
/// Контроллер для тестов
/// </summary>
[ApiController]
[Route("api/test/")]
public sealed class TestController: Controller
{
    /// <summary>
    /// Конструктор
    /// </summary>
    public TestController()
    {
        
    }

    /// <summary>
    /// 
    /// </summary>
    /// <returns></returns>
    [HttpGet("hello")]
    [ProducesResponseType(typeof(string), StatusCodes.Status200OK)]
    public IActionResult Hello()
    {
        return Ok("Hello!");
    }
}