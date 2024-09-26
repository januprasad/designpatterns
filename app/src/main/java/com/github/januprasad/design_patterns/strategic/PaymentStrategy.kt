package com.github.januprasad.design_patterns.strategic

/*class PaymentProcessor {
    private var paymentType: PaymentType? = null

    fun processPayment(amount: Double) {
        if (paymentType == PaymentType.CREDIT_CARD) {
            println("Processing credit card payment of amount $amount")
        } else if (paymentType == PaymentType.DEBIT_CARD) {
            println("Processing debit card payment of amount $amount")
        } else if (paymentType == PaymentType.PAYPAL) {
            println("Processing PayPal payment of amount $amount")
        } else {
            throw IllegalArgumentException("Invalid payment type")
        }
    }

    fun setPaymentType(paymentType: PaymentType?) {
        this.paymentType = paymentType
    }
}*/

enum class PaymentType {
    CREDIT_CARD,
    DEBIT_CARD,
    PAYPAL
}


interface PaymentStrategy {
    fun processPayment(amount: Double)
}

class CreditCardPaymentStrategy : PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Processing credit card payment of amount $amount")
    }
}
class DebitCardPaymentStrategy : PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Processing debit card payment of amount $amount")
    }
}

class PaypalPaymentStrategy : PaymentStrategy {
    override fun processPayment(amount: Double) {
        println("Processing PayPal payment of amount $amount")
    }
}

class PaymentProcessor(private val paymentStrategy: PaymentStrategy) {
    fun processPayment(amount: Double) {
        paymentStrategy.processPayment(amount)
    }
}

fun main() {
    val paymentStrategy = CreditCardPaymentStrategy()
    val paymentProcessor = PaymentProcessor(paymentStrategy)
    paymentProcessor.processPayment(100.8)
}
