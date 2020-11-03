package com.evaluation.book.adapter.viewholder

import android.view.View
import com.evaluation.adapter.AdapterItemClickListener
import com.evaluation.adapter.viewholder.BaseViewHolder
import com.evaluation.book.adapter.viewholder.item.CardItemView
import com.evaluation.utils.loadFromUrl
import kotlinx.android.synthetic.main.card_item.view.*

/**
 * @author Vladyslav Havrylenko
 * @since 03.10.2020
 */
class CardItemHolder(itemView: View, listener: AdapterItemClickListener<CardItemView>?) : BaseViewHolder<CardItemView>(itemView, listener) {

    override fun bind(item: CardItemView) {
        itemView.image.loadFromUrl(item.book.smallThumbnail)
        itemView.setOnClickListener {
            listener?.onClicked(item)
        }
    }

}