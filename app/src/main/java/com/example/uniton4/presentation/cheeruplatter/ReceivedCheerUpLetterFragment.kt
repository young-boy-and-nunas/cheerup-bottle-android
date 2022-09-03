package com.example.uniton4.presentation.cheeruplatter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.databinding.FragmentReceivedCheerupLetterBinding
import com.example.uniton4.domain.ReceivedCheerUpLetterEntity
import com.example.uniton4.presentation.cheeruplatter.adapter.ReceivedCheerUpLetterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReceivedCheerUpLetterFragment: Fragment() {
    lateinit var binding: FragmentReceivedCheerupLetterBinding

    private val parentViewModel: MainViewModel by activityViewModels()
    private val adapter by lazy {
        ReceivedCheerUpLetterAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentReceivedCheerupLetterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.recyclerView.adapter = adapter
        adapter.submitList(createMockData())
        binding.addButton.setOnClickListener {
            parentViewModel.navigateByReplace(NavigateScreenType.WRITE_SED_LETTER)
        }
        binding.header.headerSettingButton.setOnClickListener {
            parentViewModel.navigateByAdd(NavigateScreenType.SETTING)
        }
    }

    private fun createMockData(): List<ReceivedCheerUpLetterEntity> {
        return listOf(
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "djksdk 님의 사연",
                description = "제가 일은 똑바로 한 거 같은데 사수님이 자꾸 혼을\n" +
                        "내요 ㅡㅡ.. 그럴거면 너가 하시던가요~~",
                date = "2022.9.3 (토)",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "djksdk 님의 사연",
                description = "제가 일은 똑바로 한 거 같은데 사수님이 자꾸 혼을\n" +
                        "내요 ㅡㅡ.. 그럴거면 너가 하시던가요~~",
                date = "2022.9.3 (토)",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "djksdk 님의 사연",
                description = "제가 일은 똑바로 한 거 같은데 사수님이 자꾸 혼을\n" +
                        "내요 ㅡㅡ.. 그럴거면 너가 하시던가요~~",
                date = "2022.9.3 (토)",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "djksdk 님의 사연",
                description = "제가 일은 똑바로 한 거 같은데 사수님이 자꾸 혼을\n" +
                        "내요 ㅡㅡ.. 그럴거면 너가 하시던가요~~",
                date = "2022.9.3 (토)",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "djksdk 님의 사연",
                description = "제가 일은 똑바로 한 거 같은데 사수님이 자꾸 혼을\n" +
                        "내요 ㅡㅡ.. 그럴거면 너가 하시던가요~~",
                date = "2022.9.3 (토)",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "djksdk 님의 사연",
                description = "제가 일은 똑바로 한 거 같은데 사수님이 자꾸 혼을\n" +
                        "내요 ㅡㅡ.. 그럴거면 너가 하시던가요~~",
                date = "2022.9.3 (토)",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "djksdk 님의 사연",
                description = "제가 일은 똑바로 한 거 같은데 사수님이 자꾸 혼을\n" +
                        "내요 ㅡㅡ.. 그럴거면 너가 하시던가요~~",
                date = "2022.9.3 (토)",
                image = ""
            ),
        )
    }
    
    companion object {
        fun newInstance() = ReceivedCheerUpLetterFragment()
    }
}
