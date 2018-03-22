package com.echain.odane.echain.Fragments.TabFragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.echain.odane.echain.Adapters.PlaceAdapter
import com.echain.odane.echain.Models.Place

import com.echain.odane.echain.R
import kotlinx.android.synthetic.main.explore_tab.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ExploreTab.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ExploreTab.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreTab : Fragment() {

    private var recyclerView: RecyclerView? = null

    private var TAG = "EXPLORE_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = explore_recycler
        var adapter = PlaceAdapter(generateData()){
            Toast.makeText(this.context, it.address, Toast.LENGTH_LONG)
        }
        recyclerView?.layoutManager = LinearLayoutManager(this.context)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    fun generateData(): ArrayList<Place>{
        var result = ArrayList<Place>()
        var list = listOf(1,2)
        for (i in 0..100) {
            var place = Place(i.toString(),"test", "test address ${i}", list.shuffled().take(1)[0])
            result.add(place)
        }
        return result
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.explore_tab, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }
}// Required empty public constructor
