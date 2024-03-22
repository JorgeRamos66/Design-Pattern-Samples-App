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
package com.github.odaridavid.designpatterns.ui;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.odaridavid.designpatterns.databinding.ItemDesignPatternBinding
import com.github.odaridavid.designpatterns.models.DesignPattern


internal class DesignPatternsAdapter(val onClick: (DesignPattern) -> Unit) :
    ListAdapter<DesignPattern, DesignPatternsAdapter.DesignPatternViewHolder>(DiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DesignPatternViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemDesignPatternBinding.inflate(inflater)
        return DesignPatternViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DesignPatternViewHolder, position: Int): Unit =
        getItem(position).let { holder.bind(it) }

    internal inner class DesignPatternViewHolder(private val binding: ItemDesignPatternBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

         fun bind(designPattern: DesignPattern) {
            val context = binding.root.context
            binding.patternNameTextView.text = context.getString(designPattern.name)
            binding.root.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val designPattern = getItem(adapterPosition)
            onClick(designPattern)
        }
    }


    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<DesignPattern>() {
            override fun areItemsTheSame(oldItem: DesignPattern, newItem: DesignPattern): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: DesignPattern,
                newItem: DesignPattern
            ): Boolean = oldItem.name == newItem.name && oldItem.description == newItem.description
        }
    }
}