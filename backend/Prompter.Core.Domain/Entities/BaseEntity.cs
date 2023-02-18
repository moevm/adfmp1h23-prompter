namespace Prompter.Core.Domain.Entities;

public abstract class BaseEntity: IEquatable<BaseEntity>
{
    public Guid Id { get; set; } = Guid.NewGuid();
    public DateTime CreatedAt { get; set; }
    public DateTime UpdatedAt { get; set; }

    public bool Equals(BaseEntity? other) => other is not null && Id.Equals(other.Id);
}