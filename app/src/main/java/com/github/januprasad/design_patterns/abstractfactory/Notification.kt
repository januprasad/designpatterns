package com.github.januprasad.design_patterns.abstractfactory

interface Notification {
    fun send(message: String)
}
class EmailNotification(private val recipient: String) : Notification {
    override fun send(message: String) {
        println("Sending Email to $recipient: $message")
    }
}

class SMSNotification(private val phoneNumber: String) : Notification {
    override fun send(message: String) {
        println("Sending SMS to $phoneNumber: $message")
    }
}
interface NotificationFactory {
    fun createNotification(type: String, recipient: String): Notification
}

/**
 * We will implement concrete factories for Admin and User notifications.
 */
class AdminNotificationFactory : NotificationFactory {
    override fun createNotification(type: String, recipient: String): Notification {
        return when (type.lowercase()) {
            "email" -> EmailNotification(recipient)
            "sms" -> SMSNotification(recipient)
            else -> throw IllegalArgumentException("Unknown notification type")
        }
    }
}

class UserNotificationFactory : NotificationFactory {
    override fun createNotification(type: String, recipient: String): Notification {
        return when (type.lowercase()) {
            "email" -> EmailNotification(recipient)
            "sms" -> SMSNotification(recipient)
            else -> throw IllegalArgumentException("Unknown notification type")
        }
    }
}
