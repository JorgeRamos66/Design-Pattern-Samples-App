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
package com.github.odaridavid.designpatterns.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.odaridavid.designpatterns.databinding.ItemLibraryBinding
import com.mikepenz.aboutlibraries.entity.Library


internal class LibrariesAdapter(val onClick: (String) -> Unit) :
    ListAdapter<Library, LibrariesAdapter.LicenseViewHolder>(DiffUtil) {

    override fun onBindViewHolder(holder: LicenseViewHolder, position: Int) {
        getItem(position).let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LicenseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLibraryBinding.inflate(inflater, parent, false)
        return LicenseViewHolder(binding)
    }

    internal inner class LicenseViewHolder(private val binding: ItemLibraryBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(library: Library) {
            binding.libraryAuthor.text = library.author
            binding.libraryName.text = library.libraryName
            binding.libraryVersion.text = library.libraryVersion
            binding.root.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val library = getItem(adapterPosition)
            onClick(library.repositoryLink)
        }
    }

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<Library>() {
            override fun areItemsTheSame(oldItem: Library, newItem: Library): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Library, newItem: Library): Boolean {
                return oldItem.libraryVersion == newItem.libraryVersion &&
                        oldItem.libraryName == newItem.libraryName
            }
        }
    }
}