package zone.yue.t

import jakarta.persistence.*
import org.hibernate.Hibernate
import org.springframework.data.annotation.ReadOnlyProperty

@Entity
data class TEntity(
    @Column(unique = true) val code: String = "",
    @ReadOnlyProperty val url: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    val count: Long = 0

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