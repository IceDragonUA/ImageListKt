package com.evaluation.view

import android.content.Context
import android.content.res.Configuration
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.evaluation.adapter.AdapterItemClickListener
import com.evaluation.adapter.CustomListAdapter
import com.evaluation.adapter.factory.TypesFactoryImpl
import com.evaluation.adapter.viewholder.item.BaseItemView
import com.evaluation.utils.ROWS_LAND
import com.evaluation.utils.ROWS_PORT

/**
 * @author Vladyslav Havrylenko
 * @since 03.10.2020
 */
class CustomRecyclerView : RecyclerView, AdapterItemClickListener<BaseItemView> {

    lateinit var listener: AdapterItemClickListener<BaseItemView>

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        layoutManager = GridLayoutManager(context, spanCount(resources.configuration))
        adapter = CustomListAdapter(TypesFactoryImpl(), this)
        itemAnimator = null
    }

    override fun getAdapter(): CustomListAdapter =
        super.getAdapter() as CustomListAdapter

    override fun onClicked(item: BaseItemView) {
        listener.onClicked(item)
    }

    override fun onConfigurationChanged(configuration: Configuration) {
        super.onConfigurationChanged(configuration)
        layoutManager = GridLayoutManager(context, spanCount(configuration))
    }

    private fun spanCount(configuration: Configuration) =
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) ROWS_LAND else ROWS_PORT
}