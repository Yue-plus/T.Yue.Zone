package zone.yue.t

import jakarta.persistence.*
import org.hibernate.Hibernate
import org.springframework.data.annotation.ReadOnlyProperty

@Entity
data class TEntity(
    @ReadOnlyProperty @Column(unique = true) val sha1: String = "",
    @ReadOnlyProperty val url: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    private var count: Long = 0

    fun addCount() {
        count++;
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as TEntity

        return (id != null) && (id == other.id)
    }

    override fun hashCode(): Int = javaClass.hashCode()

    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}