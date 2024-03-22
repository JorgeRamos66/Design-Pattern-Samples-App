/**
  *
  * Copyright 2020 David Odari
  *
  * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia"); No puedes utilizar este archivo excepto
  * de conformidad con la Licencia. Puede obtener una copia de la Licencia en
  * http://www.apache.org/licenses/LICENSE-2.0
  * A menos que lo exija la ley aplicable o se acuerde por escrito, el software distribuido bajo la Licencia
  * se distribuye "TAL CUAL", SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas
  * o implícito. Consulte la Licencia para conocer el idioma específico que rige los permisos y limitaciones en
  * la licencia.
  *
  **/
package com.github.odaridavid.designpatterns.patterns.chainofresponsibility

internal interface OrderHandler {
    val nextHandler: OrderHandler?
    fun handleRequest(order: Order)
}

internal interface Order {
    val items: Map<String, Int>
}

internal class IceCreamOrder(override val items: Map<String, Int>) : Order

internal class IceCreamVendor(override val nextHandler: OrderHandler?) : OrderHandler {
    override fun handleRequest(order: Order) {
        val orderSize = order.items.values.sum()
        if (orderSize > 5) {
            println("Vendor: I'll have to get some")
            nextHandler?.handleRequest(order) ?:return
        } else {
            println("OrderTransaction of ${order.items.keys} coming right up")
        }
    }
}

internal class IceCreamRetailer(override val nextHandler: OrderHandler?) : OrderHandler {
    override fun handleRequest(order: Order) {
        val orderSize = order.items.values.sum()
        if (orderSize > 10) {
            println("Retailer: Hmm guess I'll have to order more too")
            nextHandler?.handleRequest(order) ?:return
        } else {
            println("OrderTransaction of ${order.items.keys} enroute to vendor")
        }
    }
}

internal class IceCreamFactory(override val nextHandler: OrderHandler?) : OrderHandler {
    override fun handleRequest(order: Order) {
        val orderSize = order.items.values.sum()
        if (orderSize > 100) {
            nextHandler?.handleRequest(order) ?:return
        } else {
            println("Factory: OrderTransaction of ${order.items.keys} coming enroute to retailer")
        }
    }
}

