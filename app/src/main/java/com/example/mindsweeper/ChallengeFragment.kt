package com.example.mindsweeper

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mindsweeper.databinding.FragmentChallengeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChallengeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChallengeFragment : Fragment() {
    private val TAG = "ChallengeFragment"

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentChallengeBinding? = null  // backing property
    private val binding get() = _binding!!  // not-null asserstion operator

    private val rows = 6
    private val cols = 6

    val tileTable = arrayOfNulls<Array<ImageView>>(rows)
    val mineField = Array(rows) { BooleanArray(cols) }

    val tileClickListener = View.OnClickListener {
//        Log.d(TAG, ": Tile ${it?.tag ?: "no tag"} clicked!")

        if (it != null) {
            val pos = it.tag.toString().split(", ")
            val row = pos[0].toInt()
            val col = pos[1].toInt()
            Log.d(TAG, "tileClickListener: row $row, col $col")
            // Check tile (row, col): mine or clear?
        }
    }

    fun tileCheck(row: Int, col: Int) {


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_challenge, container, false)
        _binding = FragmentChallengeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tileTable[0] = arrayOf(
            binding.tile00,
            binding.tile01,
            binding.tile02,
            binding.tile03,
            binding.tile04,
            binding.tile05
        )

        tileTable[1] = arrayOf(
            binding.tile10,
            binding.tile11,
            binding.tile12,
            binding.tile13,
            binding.tile14,
            binding.tile15
        )

        tileTable[2] = arrayOf(
            binding.tile20,
            binding.tile21,
            binding.tile22,
            binding.tile23,
            binding.tile24,
            binding.tile25
        )

        tileTable[3] = arrayOf(
            binding.tile30,
            binding.tile31,
            binding.tile32,
            binding.tile33,
            binding.tile34,
            binding.tile35
        )

        tileTable[4] = arrayOf(
            binding.tile40,
            binding.tile41,
            binding.tile42,
            binding.tile43,
            binding.tile44,
            binding.tile45
        )

        tileTable[5] = arrayOf(
            binding.tile50,
            binding.tile51,
            binding.tile52,
            binding.tile53,
            binding.tile54,
            binding.tile55
        )

        for (r in 0 until rows)
            for (c in 0 until cols)
                tileTable[r]?.get(c)?.setOnClickListener(tileClickListener)

        // Initialize the mine field table with, say, 15% mines.

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChallengeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChallengeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}