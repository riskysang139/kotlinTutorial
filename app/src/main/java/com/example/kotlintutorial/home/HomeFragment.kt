package com.example.kotlintutorial.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.kotlintutorial.R
import com.example.kotlintutorial.base.Constant
import com.example.kotlintutorial.base.HorizontalItemDecorationNew
import com.example.kotlintutorial.base.Utils
import com.example.kotlintutorial.databinding.FragmentHomeBinding

class HomeFragment : Fragment() , CategoryAdapter.OnClick{
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var listNowPlayingFilm: List<ResultsFilm>
    private lateinit var nowPlayingAdapter: NowPlayingFilmAdapter
    private lateinit var listUpComingFilm: List<ResultsFilm>
    private lateinit var categoryAdapter: CategoryAdapter

    companion object {
        val instance: HomeFragment
            get() {
                val args = Bundle()
                val homeFragment = HomeFragment()
                homeFragment.arguments = args
                return homeFragment
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = requireActivity()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        observerPlayingFilm()
    }

    private fun observerPlayingFilm() {
        viewModel.fetchNowPlayingFilm(Constant.API_KEY, 1)
        viewModel.getNowPlayingFilm().observe(viewLifecycleOwner) { t: ResultResponse ->
            listNowPlayingFilm = t.results
            nowPlayingAdapter = NowPlayingFilmAdapter(listNowPlayingFilm)
            binding.listNowPlaying.adapter = nowPlayingAdapter
            onAutoScrollAD()
        }
    }

    private fun setupAdapter() {
        categoryAdapter = CategoryAdapter(Category.insertType(), this)
        binding.rcvCategory.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rcvCategory.addItemDecoration(HorizontalItemDecorationNew(Utils.dpToPx(requireContext(), 12), 0))
        binding.rcvCategory.adapter = categoryAdapter
    }

    private fun onAutoScrollAD() {
        binding.listNowPlaying.clipToPadding = false
        binding.listNowPlaying.clipChildren = false
        binding.listNowPlaying.offscreenPageLimit = 3
        binding.listNowPlaying.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_ALWAYS
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(
            MarginPageTransformer(
                Utils.dpToPx(
                    requireContext(),
                    8
                )
            )
        )
        compositePageTransformer.addTransformer { page: View, position: Float ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.8f + r * 0.2f
        }
        binding.listNowPlaying.setPageTransformer(compositePageTransformer)
    }

    //on click category item
    override fun onClickItem(category: Category, position: Int) {
//        category.isChoose = category.isChoose != true
//        categoryAdapter.notifyItemChanged(position)
    }
}