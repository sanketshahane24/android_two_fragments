package com.csuf.twoviewpoc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FirstFragment : Fragment() {

    lateinit var firstBtn:Button
    lateinit var counter:Button;
    lateinit var countText:TextView;
    var count:Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        this.firstBtn =view.findViewById(R.id.first_btn)

        this.counter = view.findViewById(R.id.count_btn);
        this.countText = view.findViewById(R.id.counter);

        this.counter.setOnClickListener {
            this.count = this.count + 1;
            this.countText.text = this.count.toString();
        }

        this.firstBtn.setOnClickListener {

            val bundle = Bundle()
            bundle.putInt("count",this.count)
            val frag = SecondFragment();
            frag.arguments = bundle

            activity?.
            supportFragmentManager?.
            beginTransaction()
                ?.replace(R.id.main_content, frag)?.
                    addToBackStack(null)?.commit();
        }

        return view;
    }



}