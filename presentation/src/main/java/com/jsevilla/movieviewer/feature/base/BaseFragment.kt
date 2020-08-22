package com.jsevilla.movieviewer.feature.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

abstract class BaseFragment<T : ViewDataBinding, out ViewModelType : BaseViewModel<*>>(clazz: KClass<ViewModelType>) :
    Fragment() {

    private lateinit var viewDataBinding: T
    private lateinit var rootView: View
    val myViewModel: ViewModelType by viewModel(clazz)

    /**
     * This function associate the xml file to the class.
     * In order to pass it to onCreateView and bind it.
     * @return layout id
     */
    abstract val getLayoutId: Int

    /**
     * Return the binding variable of the XML
     * associated to this class.
     * @return binding variable ID
     */
    abstract val getBindingVariable: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (myViewModel == null) {
            throw Exception("View Model must not be null.")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId, container, false)
        rootView = viewDataBinding.root
        viewDataBinding.setVariable(getBindingVariable, myViewModel)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        viewDataBinding.executePendingBindings()
        if (savedInstanceState == null)
            onFragmentViewReady(view)
    }

    abstract fun onFragmentViewReady(view: View)

    /**
     * Add a fragment above the current fragment. Also allows to use the back stack.
     *
     * @param containerId the frameLayout id.
     * @param fragment the fragment to add.
     * @param fromParent if true the we have to use activity?.supportFragmentManager.
     */
    protected fun addFragment(
        containerId: Int,
        fragment: Fragment,
        fromParent: Boolean = false
    ) {
        val fragmentTransaction = if (fromParent) {
            activity?.supportFragmentManager?.beginTransaction()
        } else {
            fragmentManager?.beginTransaction()
        }
        fragmentTransaction?.add(containerId, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }
}
