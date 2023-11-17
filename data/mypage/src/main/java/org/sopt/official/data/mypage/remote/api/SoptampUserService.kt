/*
 * MIT License
 * Copyright 2023 SOPT - Shout Our Passion Together
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.sopt.official.data.mypage.remote.api

import org.sopt.official.data.mypage.model.request.UpdateNicknameRequest
import org.sopt.official.data.mypage.model.request.UpdateProfileMessageRequest
import org.sopt.official.data.mypage.model.response.UpdateProfileMessageResponse
import org.sopt.official.data.mypage.model.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface SoptampUserService {
    // 닉네임 중복검사
    @GET("user/nickname/{nickname}")
    suspend fun checkNickname(@Path("nickname") nickname: String)

    @GET("user/soptamp")
    suspend fun getUserInformation(): UserResponse

    // 닉네임 변경
    @PATCH("user/nickname")
    suspend fun updateNickname(@Body nickname: UpdateNicknameRequest)

    @PATCH("user/profile-message")
    suspend fun updateProfileMessage(
        @Body profileMessage: UpdateProfileMessageRequest
    ): UpdateProfileMessageResponse
}