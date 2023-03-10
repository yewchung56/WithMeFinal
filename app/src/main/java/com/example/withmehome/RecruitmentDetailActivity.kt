package com.example.withmehome

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.example.withmehome.databinding.ActivityRecruitmentDetailBinding
import com.kakao.sdk.user.UserApiClient
import kotlinx.android.synthetic.main.activity_recruitment_detail.*
import java.util.*



class RecruitmentDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recruitment_detail)

        var nickname = findViewById<TextView>(R.id.txt_name)
        //var email = findViewById<TextView>(R.id.txt_user_address)
        val imageView = findViewById<ImageView>(R.id.recruitment_detail_userphoto)
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

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayoutrecruit, RecruitFragment())
            .commitAllowingStateLoss()

        val sharedPreference = getSharedPreferences("RecruitmentDetail", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreference.edit()

        calanderButton_create.setOnClickListener() {

            val builder = MaterialDatePicker.Builder.datePicker() //datePicker를 만들어줍니다.
                .setTitleText("시작일 선택") //DatePicker창에 타이틀을 정해줍니다.
                .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT) //첫번째 목표 이미지처럼 캘린더를 숨기고싶을때 활성화 하시면됩니다.
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())//기본 선택값을정하는곳이고 오늘로 설정했습니다.

            val datePicker = builder.build()

            datePicker.addOnPositiveButtonClickListener {
                val calendar = Calendar.getInstance()
                //선택한 날짜를 Date format으로 가져오기
                calendar.time = Date(it)
                //선택한 날짜를 밀리세컨드로 값으로 가져오기
                val calendarMilli = calendar.timeInMillis
                //버튼text를에 선택한 날짜로바꿔주기
                calanderButton_create.text =
                    "${calendar.get(Calendar.MONTH) + 1}/${calendar.get(Calendar.DAY_OF_MONTH)}/${
                        calendar.get(Calendar.YEAR)
                    }"

                //sharedPreference에 저장하기
                editor.putLong("Start_Millis", calendarMilli)
                editor.apply()
            }
            datePicker.show(supportFragmentManager, datePicker.toString()) //datePicker를 보여주기

        }

        calanderButton_create2.setOnClickListener() {
            //calendar Constraint Builder 선택할수있는 날짜 구간설정
            val calendarConstraintBuilder = CalendarConstraints.Builder()
            //오늘 이후만 선택가능하게 하는 코드
            calendarConstraintBuilder.setValidator(DateValidatorPointForward.now())
            //오늘 이전만 선택가능하게 하는 코드
            //calendarConstraintBuilder.setValidator(DateValidatorPointBackward.now())


            val builder = MaterialDatePicker.Builder.datePicker()
                .setTitleText("마감일 선택")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())

                //위에서 만든 calendarConstraint을 builder에 설정해줍니다.
                .setCalendarConstraints(calendarConstraintBuilder.build());

            val datePicker = builder.build()

            datePicker.addOnPositiveButtonClickListener {
                val calendar = Calendar.getInstance()
                calendar.time = Date(it)
                val calendarMilli = calendar.timeInMillis
                calanderButton_create2.text =
                    "${calendar.get(Calendar.MONTH) + 1}/${calendar.get(Calendar.DAY_OF_MONTH)}/${
                        calendar.get(Calendar.YEAR)
                    }"

                //sharedPreference
                editor.putLong("End_Millis", calendarMilli)
                editor.apply()
                Log.d("End_Millis", "$calendarMilli")
            }
            datePicker.show(supportFragmentManager, datePicker.toString())
        }
        recruit_end.setOnClickListener{
                startActivity(Intent(this@RecruitmentDetailActivity,RecruitmentDetailDeadlineActivity::class.java))
        }
    }
}