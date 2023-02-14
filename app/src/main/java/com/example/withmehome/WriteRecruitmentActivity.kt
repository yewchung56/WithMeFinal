package com.example.withmehome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import com.example.withmehome.RetrofitApi.jsonObject
import com.example.withmehome.databinding.ActivityWriteRecruitmentBinding
import com.kakao.sdk.user.UserApiClient
import kotlinx.android.synthetic.main.activity_write_recruitment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.json.JSONArray
import org.json.JSONObject

class WriteRecruitmentActivity : AppCompatActivity() {

    lateinit var binding: ActivityWriteRecruitmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteRecruitmentBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var nickname = findViewById<TextView>(R.id.txt_writer_name)
        var email = findViewById<TextView>(R.id.txt_user_address)
        val imageView = findViewById<ImageView>(R.id.img_writer)
        val defaultImage = R.drawable.ic_recruitment_detail_photo



        UserApiClient.instance.me { user, error ->
            nickname.text = "${user?.kakaoAccount?.profile?.nickname}"
            //email.text = "${user?.kakaoAccount?.email}"
            Log.d("닉네임:","${user?.kakaoAccount?.email}")
            var url = "${user?.kakaoAccount?.profile?.thumbnailImageUrl}"

            Glide.with(this)
                .load(url) // 불러올 이미지 url
                .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .circleCrop() // 동그랗게 자르기
                .into(imageView) // 이미지를 넣을 뷰
        }

        val items_category = resources.getStringArray(R.array.spinner_category)
        val items_region = resources.getStringArray(R.array.spinner_region)
        val items_region_seoul = resources.getStringArray(R.array.spinner_region_seoul)
        val items_region_busan = resources.getStringArray(R.array.spinner_region_busan)
        val items_region_incheon = resources.getStringArray(R.array.spinner_region_incheon)
        val items_region_daegu = resources.getStringArray(R.array.spinner_region_daegu)
        val items_region_gwangju = resources.getStringArray(R.array.spinner_region_gwangju)
        val items_region_daejeon = resources.getStringArray(R.array.spinner_region_daejeon)
        val items_region_ulsan = resources.getStringArray(R.array.spinner_region_ulsan)
        val items_region_sejong = resources.getStringArray(R.array.spinner_region_sejong)
        val items_region_gyeonggi = resources.getStringArray(R.array.spinner_region_gyeonggi)
        val items_region_gangwon = resources.getStringArray(R.array.spinner_region_gangwon)
        val items_region_chung_buk = resources.getStringArray(R.array.spinner_region_chung_buk)
        val items_region_chung_nam = resources.getStringArray(R.array.spinner_region_chung_nam)
        val items_region_gyeong_buk = resources.getStringArray(R.array.spinner_region_gyeong_buk)
        val items_region_gyeong_nam = resources.getStringArray(R.array.spinner_region_gyeong_nam)
        val items_region_jeon_buk = resources.getStringArray(R.array.spinner_region_jeon_buk)
        val items_region_jeon_nam = resources.getStringArray(R.array.spinner_region_jeon_nam)
        val items_region_jeju = resources.getStringArray(R.array.spinner_region_jeju)

        val categoryAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_category)
        val regionAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region)
        val seoulAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_seoul)
        val busanAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_busan)
        val incheonAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_incheon)
        val daeguAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_daegu)
        val gwangjuAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_gwangju)
        val daejeonAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_daejeon)
        val ulsanAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_ulsan)
        val sejongAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_sejong)
        val gyeonggiAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_gyeonggi)
        val gangwonAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_gangwon)
        val chungbukAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            items_region_chung_buk
        )
        val chungnamAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            items_region_chung_nam
        )
        val gyeongbukAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            items_region_gyeong_buk
        )
        val gyeongnamAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            items_region_gyeong_nam
        )
        val jeonbukAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_jeon_buk)
        val jeonnamAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_jeon_nam)
        val jejuAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_region_jeju)


        // 뷰와 어뎁터 연결
        binding.spinnerCategory.adapter = categoryAdapter
        binding.spinnerCity.adapter = regionAdapter

        // 어뎁터가 연결된 뷰를 이용해서 이벤트 설정
        // 카테고리 스피너
        binding.spinnerCategory.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    binding.spinnerCity.selectedItem.toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    binding.spinnerCategory.setSelection(0)
                }

            }

        // 시 스피너
        binding.spinnerCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.spinnerCity.selectedItem.toString()

                // 0을 선택했을 경우는?
                when (binding.spinnerCity.selectedItemPosition) {
                    0 -> binding.spinnerDistrict.adapter = null
                    1 -> binding.spinnerDistrict.adapter = seoulAdapter
                    2 -> binding.spinnerDistrict.adapter = busanAdapter
                    3 -> binding.spinnerDistrict.adapter = incheonAdapter
                    4 -> binding.spinnerDistrict.adapter = daeguAdapter
                    5 -> binding.spinnerDistrict.adapter = gwangjuAdapter
                    6 -> binding.spinnerDistrict.adapter = daejeonAdapter
                    7 -> binding.spinnerDistrict.adapter = ulsanAdapter
                    8 -> binding.spinnerDistrict.adapter = sejongAdapter
                    9 -> binding.spinnerDistrict.adapter = gyeonggiAdapter
                    10 -> binding.spinnerDistrict.adapter = gangwonAdapter
                    11 -> binding.spinnerDistrict.adapter = chungbukAdapter
                    12 -> binding.spinnerDistrict.adapter = chungnamAdapter
                    13 -> binding.spinnerDistrict.adapter = gyeongbukAdapter
                    14 -> binding.spinnerDistrict.adapter = gyeongnamAdapter
                    15 -> binding.spinnerDistrict.adapter = jeonbukAdapter
                    16 -> binding.spinnerDistrict.adapter = jeonnamAdapter
                    17 -> binding.spinnerDistrict.adapter = jejuAdapter
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                binding.spinnerCity.setSelection(0)
            }
        }

        // 군 구 스피너
        binding.spinnerDistrict.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    binding.spinnerCity.selectedItem.toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
        // seekbar 값 보여주기
        binding.seekNum.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.txtFinalNum.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        // 제출 버튼 클릭
        btn_write_complete.setOnClickListener {
            //retorfitWriteRec()
            startActivity(
                Intent(
                    this@WriteRecruitmentActivity,
                    RecruitmentDetailActivity::class.java
                )
            )
        }

        try {

            // ------------------------------------

            // [jsonObject 선언 및 데이터 삽입 실시]
            val jsonObject = JSONObject()
            jsonObject.put("name", "투케이")
            jsonObject.put("age", 29)


            // [jsonArray 선언 및 데이터 삽입 실시]
            val jsonArray = JSONArray()
            jsonArray.put("하나")
            jsonArray.put("둘")


            // [로그 결과 출력 실시]
            Log.i("---", "---")
            Log.w("//===========//", "================================================")
            Log.i("", "\n" + "[Test_Kotlin > testMain() 메소드 : 로그 출력 결과 확인]")
            Log.i("", "\n" + "[jsonObject : " + jsonObject.toString() + "]")
            Log.i("", "\n" + "[jsonArray : " + jsonArray.toString() + "]")
            Log.w("//===========//", "================================================")
            Log.i("---", "---")

            // ------------------------------------
        } catch (e: Exception) {
            Log.i("---", "---")
            Log.e("//===========//", "================================================")
            Log.i("", "\n" + "[Test_Kotlin > testMain() 메소드 : 에러 상황 발생]")
            Log.i("", "\n" + "[error : " + e.message + "]")
            Log.e("//===========//", "================================================")
            Log.i("---", "---")
        }
    }

    //address.add(viewBinding.spinnerCity.selectedItem.toString())
    //val address = listOf<String>( binding.spinnerCity.selectedItem.toString(),binding.spinnerDistrict.selectedItem.toString())
/*
    private fun retorfitWriteRec() {
        val service = RetrofitApi.writeRecruitmentService
        service.WriteRecService(
        ).enqueue(object : Callback<WriteRecruitmentResponse> {
                override fun onResponse(
                    call: Call<WriteRecruitmentResponse>,
                    response: Response<WriteRecruitmentResponse>
                ) {
                    if(response.isSuccessful){
                        Log.d("Tag", response.body()?.success.toString())
                        Log.d("Tag", response.body()?.data?.meetId.toString())
                    }
                    else{
                        Log.d("fail","k")
                    }
                }
                override fun onFailure(call: Call<WriteRecruitmentResponse>, t: Throwable) {
                    Log.d("Tag", t.message.toString())
                }
            })
    }
*/

}