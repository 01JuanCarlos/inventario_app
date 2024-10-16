package com.aero.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

open class ProductAdapter(private val listener: MainActivity) : RecyclerView.Adapter<ProductViewHolder>() {

    private var products = mutableListOf<Product>()

    fun setProducts(products: List<Product>) {
        this.products.clear()  // Limpia la lista actual
        this.products.addAll(products)  // Agrega los nuevos productos
        notifyDataSetChanged()  // Notifica al adaptador de los cambios
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)

        // Configurar el clic para editar
        holder.itemView.setOnClickListener {
            listener.onEditClick(product)
        }

        // Agregar un botón o icono para eliminar el producto
        holder.itemView.findViewById<ImageButton>(R.id.btnDelete).setOnClickListener {
            listener.onDeleteClick(product)
        }
    }

    override fun getItemCount(): Int = products.size
}

