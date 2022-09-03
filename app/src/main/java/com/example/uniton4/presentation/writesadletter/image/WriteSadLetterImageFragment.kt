package com.example.uniton4.presentation.writesadletter.image

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.uniton4.data.request.ContentUriRequestBody
import com.example.uniton4.databinding.FragmentWriteSadLetterImageBinding
import com.example.uniton4.presentation.writesadletter.WriteSadLetterViewModel

class WriteSadLetterImageFragment : Fragment() {
    private lateinit var binding: FragmentWriteSadLetterImageBinding
    private val parentViewModel: WriteSadLetterViewModel by viewModels({ requireParentFragment() })

    private val imageResultLaunch =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val imageUrl = result.data?.data
                imageUrl?.let {
                    val requestImageUri = ContentUriRequestBody(requireContext(), imageUrl)
                    showGalleryImage(imageUrl)
                    Log.e("@222", imageUrl.toString())
                }
            }
        }

    private fun showGalleryImage(imageUrl: Uri) {
        binding.selectedImage.setImageURI(imageUrl)
        parentViewModel.activeCompleteButton()
        binding.selectedImage.visibility = View.VISIBLE
        binding.selectedImage.visibility = View.GONE
    }

    // 완료버튼 눌렀을 때 데이터 전송되도록 해야함.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteSadLetterImageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.dottedContainer.setOnClickListener {
            startDefaultGalleryApp()
        }
    }

    private fun startDefaultGalleryApp() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        imageResultLaunch.launch(intent)
    }

    companion object {
        fun newInstance() = WriteSadLetterImageFragment()
    }
}
