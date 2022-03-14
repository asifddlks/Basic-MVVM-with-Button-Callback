package com.asifddlks.basicmvvmwithbuttonclick

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import com.asifddlks.basicmvvmwithbuttonclick.databinding.TestFragmentBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TestFragment : Fragment(), LifecycleObserver{

    private lateinit var viewModel: TestViewModel
    lateinit var binding: TestFragmentBinding

    companion object {
        fun newInstance() = TestFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = TestFragmentBinding.inflate(inflater, container, false)
        return binding.root

        //return inflater.inflate(R.layout.test_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)


        binding.button.setOnClickListener{
            //binding.textView.text = binding.editText.text.toString()
            viewModel.callback.buttonClicked(binding.editText.text.toString())
        }

       // binding.textView.text = viewModel.sampleData.value
        /*viewModel.sampleData.observe(viewLifecycleOwner, Observer {
            binding.textView.text = viewModel.sampleData.value
        })*/

        /*GlobalScope.launch {
            viewModel.sampleData.collect {
                binding.textView.text = it
            }
        }*/
        lifecycleScope.launch {
            viewModel.sampleData.collect {
                binding.textView.text = it
            }
        }

        //binding.textView.text = viewModel.sampleData.coll

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreated(){
        activity?.lifecycle?.removeObserver(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.lifecycle?.addObserver(this)
    }

}