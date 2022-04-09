package com.example.bank.ui.contactus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bank.databinding.FragmentContactusBinding
import com.example.bank.databinding.FragmentGalleryBinding
import com.example.bank.ui.gallery.GalleryViewModel

class ContactusFragment : Fragment() {

    private var _binding: FragmentContactusBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contactusViewModel =
            ViewModelProvider(this).get(ContactusViewModel::class.java)

        _binding = FragmentContactusBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}