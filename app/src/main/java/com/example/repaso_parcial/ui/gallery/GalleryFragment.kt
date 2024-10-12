package com.example.repaso_parcial.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.repaso_parcial.databinding.FragmentGalleryBinding
import com.example.repaso_parcial.ui.shared.HomeGalleryViewModel

class GalleryFragment : Fragment() {

    private val sharedViewModel: HomeGalleryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val webView = binding.wvPage
        webView.settings.javaScriptEnabled = true


        webView.webViewClient = object: WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }

        sharedViewModel.url.observe(viewLifecycleOwner) { url ->
            webView.loadUrl(url)
        }

        return binding.root

    }

}