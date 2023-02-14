import com.squareup.moshi.Json
import retrofit2.http.Field

data class NicknameSetResponse(
    @field:Json(name = "success")
    val success: Boolean?
)