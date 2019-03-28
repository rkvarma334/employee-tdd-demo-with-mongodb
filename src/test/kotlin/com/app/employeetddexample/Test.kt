package com.app.employeetddexample

import org.junit.Test


 class MaxWithtest {

     var name: String=""
     override fun equals(other: Any?): Boolean {
         return super.equals(other)
     }

     override fun hashCode(): Int {
         return super.hashCode()
     }

     override fun toString(): String {
         return super.toString()
     }

     var price: Double=0.0


    @Test
    fun testMaxWith(){

        val maxWithtest =MaxWithtest()
        maxWithtest.name="Samsung Galaxy S8 64GB Unlocked Phone"
        maxWithtest.price=699.99

        val maxWithtest1 =MaxWithtest()
        maxWithtest1.name="iPad Pro 9.7-inch 32 GB"
        maxWithtest1.price=474.98

        val maxWithtest2 =MaxWithtest()
        maxWithtest2.name="Samsung Electronics Ultra HD Smart LED TV"
        maxWithtest2.price=677.92

        val maxWithtest3 =MaxWithtest()
        maxWithtest3.name="Google Pixel Phone - 5 inch display"
        maxWithtest3.price=279.95

        val maxWithtest4 =MaxWithtest()
        maxWithtest4.name="iPad Pro 9.7-inch 128G"
        maxWithtest4.price=574.99

        val maxWithtest5 =MaxWithtest()
        maxWithtest5.name="Google Wifi system 1-Pack"
        maxWithtest5.price= 149.90


        val productList = listOf(maxWithtest,maxWithtest1,maxWithtest2,maxWithtest3,maxWithtest4,maxWithtest5)

       val productWithHighestPrice = productList.maxWith(object : Comparator<MaxWithtest> {

            override fun compare(p1: MaxWithtest, p2: MaxWithtest): Int = when {
                p1.price > p2.price -> 1
                p1.price == p2.price -> 0
                else -> -1
            }
        })

        println(productWithHighestPrice.toString())
    }


}
