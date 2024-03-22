/**
  *
  * Copyright 2020 David Odari
  *
  * Sous licence Apache, version 2.0 (la « Licence »); vous ne pouvez pas utiliser ce fichier sauf
  *dans le respect de la Licence. Vous pouvez obtenir une copie de la licence à
  * http://www.apache.org/licenses/LICENSE-2.0
  * Sauf si requis par la loi applicable ou convenu par écrit, les logiciels distribués sous la licence
  * est distribué « TEL QUEL », SANS GARANTIE NI CONDITIONS D'AUCUNE SORTE, expresses
  * ou implicite. Consultez la licence pour connaître la langue spécifique régissant les autorisations et les limitations sous
  * la licence.
  *
  **/
package com.github.odaridavid.designpatterns.models

import android.os.Parcelable
import androidx.annotation.StringRes
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.helpers.CodeSample
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class DesignPattern(
    @StringRes val name: Int,
    @StringRes val description: Int,
    val codeSample: String
) : Parcelable

internal fun generateDesignPatterns(): List<DesignPattern> {
    return listOf(
        DesignPattern(
            R.string.title_adapter,
            R.string.desc_adapter,
            CodeSample.ADAPTER
        ),
        DesignPattern(
            R.string.title_abstract_factory,
            R.string.desc_abstract_factory,
            CodeSample.ABSTRACT_FACTORY
        ),
        DesignPattern(
            R.string.title_bridge,
            R.string.desc_bridge,
            CodeSample.BRIDGE
        ),
        DesignPattern(
            R.string.title_builder,
            R.string.desc_builder,
            CodeSample.BUILDER
        ),
        DesignPattern(
            R.string.title_chain_of_responsibility,
            R.string.desc_chain_of_responsibility,
            CodeSample.CHAIN_OF_RESPONSIBILITY
        ),
        DesignPattern(
            R.string.title_command,
            R.string.desc_command,
            CodeSample.COMMAND
        ),
        DesignPattern(
            R.string.title_composite,
            R.string.desc_composite,
            CodeSample.COMPOSITE
        ),
        DesignPattern(
            R.string.title_decorator,
            R.string.desc_decorator,
            CodeSample.DECORATOR
        ),
        DesignPattern(
            R.string.title_facade,
            R.string.desc_facade,
            CodeSample.FACADE
        ),
        DesignPattern(
            R.string.title_factory,
            R.string.desc_factory,
            CodeSample.FACTORY
        ),
        DesignPattern(
            R.string.title_flyweight,
            R.string.desc_flyweight,
            CodeSample.FLYWEIGHT
        ),
        DesignPattern(
            R.string.title_iterator,
            R.string.desc_iterator,
            CodeSample.ITERATOR
        ),
        DesignPattern(
            R.string.title_mediator,
            R.string.desc_mediator,
            CodeSample.MEDIATOR
        ),
        DesignPattern(
            R.string.title_memento,
            R.string.desc_memento,
            CodeSample.MEMENTO
        ),
        DesignPattern(
            R.string.title_observer,
            R.string.desc_observer,
            CodeSample.OBSERVER
        ),
        DesignPattern(
            R.string.title_prototype,
            R.string.desc_prototype,
            CodeSample.PROTOTYPE
        ),
        DesignPattern(
            R.string.title_proxy,
            R.string.desc_proxy,
            CodeSample.PROXY
        ),
        DesignPattern(
            R.string.title_singleton,
            R.string.desc_singleton,
            CodeSample.SINGLETON
        ),
        DesignPattern(
            R.string.title_state,
            R.string.desc_state,
            CodeSample.STATE
        ),
        DesignPattern(
            R.string.title_strategy,
            R.string.desc_strategy,
            CodeSample.STRATEGY
        ),
        DesignPattern(
            R.string.title_template,
            R.string.desc_template_method,
            CodeSample.TEMPLATE_METHOD
        ),
        DesignPattern(
            R.string.title_visitor,
            R.string.desc_visitor,
            CodeSample.VISITOR
        )
    )
}

