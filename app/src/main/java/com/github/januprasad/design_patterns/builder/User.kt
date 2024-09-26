package com.github.januprasad.design_patterns.builder

/**
 * Define the Product Class: This is the class that you want to build.
 */

data class User(
    val name: String,
    val age: Int,
    val email: String? = null,
    val phone: String? = null
)

/**
 * This class helps in constructing the User object.
 */
class UserBuilder {
    private var name: String? = null
    private var age: Int? = null
    private var email: String? = null
    private var phone: String? = null

    fun setName(name: String) = apply { this.name = name }
    fun setAge(age: Int) = apply { this.age = age }
    fun setEmail(email: String?) = apply { this.email = email }
    fun setPhone(phone: String?) = apply { this.phone = phone }

    fun build(): User {
        /**
         * You can now create a User instance using the builder.
         */
        return User(
            name = name ?: throw IllegalArgumentException("Name is required"),
            age = age ?: throw IllegalArgumentException("Age is required"),
            email = email,
            phone = phone
        )
    }
}
fun main() {
    val user = UserBuilder()
        .setName("Alice")
        .setAge(30)
        .setEmail("alice@example.com")
        .build()

    println(user)
}
