package com.example.kotlintutorial.ui.home

class Promo(
    val event: String,
    val descriptionEvent: String,
    val saleOff: String
) {
    companion object {
        fun createListEvent() : MutableList<Promo>{
            val listPromo: MutableList<Promo> = mutableListOf()
            listPromo.add(Promo("Student Holiday", "Maximal only for two people", "OFF 80%"))
            listPromo.add(Promo("Summer Holiday", "Maximal only for two people", "OFF 70%"))
            listPromo.add(Promo("Workshop Holiday", "Maximal only for two people", "OFF 60%"))
            return listPromo
        }
    }
}