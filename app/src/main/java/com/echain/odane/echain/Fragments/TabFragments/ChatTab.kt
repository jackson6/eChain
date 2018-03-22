package com.echain.odane.echain.Fragments.TabFragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.echain.odane.echain.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ChatTab.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ChatTab.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatTab : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.chat_tab, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }
}// Required empty public constructor
