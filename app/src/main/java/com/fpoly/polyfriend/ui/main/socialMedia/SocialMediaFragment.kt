package com.fpoly.polyfriend.ui.main.socialMedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.fpoly.polyfriend.R
import com.fpoly.polyfriend.core.PolyBaseFragment
import com.fpoly.polyfriend.databinding.FragmentSocialMediaBinding
import com.fpoly.polyfriend.databinding.ItemTabBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.random.Random

class SocialMediaFragment : PolyBaseFragment<FragmentSocialMediaBinding>(){
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSocialMediaBinding {
        return FragmentSocialMediaBinding.inflate(layoutInflater)
    }

    lateinit var tabStoryBinding: ItemTabBinding
    lateinit var tabChatBinding: ItemTabBinding

    override fun invalidate() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabViewPager()

        views.btnBtn.setOnClickListener{
            showIndexTab(tabStoryBinding, Random.nextInt())
            showIndexTab(tabChatBinding, Random.nextInt())
        }
    }

    private fun setupTabViewPager() {
        var adapterViewPager = SocialViewPagerAdapter(childFragmentManager, lifecycle)
        views.viewpagger.adapter = adapterViewPager
        TabLayoutMediator(views.tablayout, views.viewpagger){tab, position ->
            when(position){
                0 -> {
                    tabStoryBinding = ItemTabBinding.inflate(layoutInflater)
                    tabStoryBinding.imgIcon.setImageDrawable(requireActivity().getDrawable(R.drawable.icon_story_select))
                    tabStoryBinding.tvTitle.text = "story"
                    tabStoryBinding.tvIndex.isVisible = false
                    tab.setCustomView(tabStoryBinding.root)
                }
                1 -> {
                    tabChatBinding = ItemTabBinding.inflate(layoutInflater)
                    tabChatBinding.imgIcon.setImageDrawable(requireActivity().getDrawable(R.drawable.icon_chat_select))
                    tabChatBinding.tvTitle.text = "Chat"
                    tabChatBinding.tvIndex.isVisible = false
                    tab.setCustomView(tabChatBinding.root)
                }
            }
        }.attach()
    }

    private fun showIndexTab(binding: ItemTabBinding, index: Int){
        binding.tvIndex.isVisible = index >= 0
        binding.tvIndex.text = "$index"
    }

    private fun isShowTablayout(isShow: Boolean){
        if (isShow){
            views.tablayout.animate().translationY(-1F * views.tablayout.height)
        }else{
            views.tablayout.animate().translationY(-0F * views.tablayout.height)
        }
    }

}