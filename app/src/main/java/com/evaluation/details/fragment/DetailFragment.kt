package com.evaluation.details.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.evaluation.R
import com.evaluation.databinding.DetailLayoutBinding
import com.evaluation.utils.autoCleared
import com.evaluation.utils.loadFromUrl
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Vladyslav Havrylenko
 * @since 09.10.2020
 */
@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var binding: DetailLayoutBinding by autoCleared()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_layout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRootView(DetailFragmentArgs.fromBundle(requireArguments()))
    }

    private fun initRootView(fromBundle: DetailFragmentArgs) {
        binding.image.loadFromUrl(fromBundle.imageUrl)
    }

}