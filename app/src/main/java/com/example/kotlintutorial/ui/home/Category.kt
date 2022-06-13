package com.example.kotlintutorial.ui.home

class Category {

    var type: String
    var isChoose: Boolean = false
    constructor(type: String = "") {
        this.type = type
    }


    companion object {
        fun insertType(): List<Category> {
            var listCategory: MutableList<Category> = mutableListOf()
            val category = Category("All")
            listCategory.add(category)
            val category1 = Category("Action")
            listCategory.add(category1)
            val category2 = Category("Drama")
            listCategory.add(category2)
            val category3 = Category("Anime")
            listCategory.add(category3)
            val category4 = Category("Adventure")
            listCategory.add(category4)
            val category5 = Category("Science Fiction")
            listCategory.add(category5)
            val category6 = Category("Romance")
            listCategory.add(category6)
            val category7 = Category("Cartoon")
            listCategory.add(category7)
            return listCategory
        }
    }
}