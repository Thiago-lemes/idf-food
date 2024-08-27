package entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "usuario")
data class UsuarioEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nome: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val senha: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val tipo: TipoUsuario,

    @Column(nullable = false)
    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val status: StatusUsuario = StatusUsuario.ATIVO
)

enum class TipoUsuario {
    ADMIN, FUNCIONARIO, CLIENTE
}

enum class StatusUsuario {
    ATIVO, INATIVO
}
