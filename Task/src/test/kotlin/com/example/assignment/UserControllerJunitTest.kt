package com.example.assignment

import com.example.assignment.domain.user.presentation.UserController
import com.example.assignment.domain.user.service.RefreshTokenService
import com.example.assignment.domain.user.service.SignInService
import com.example.assignment.domain.user.service.SignUpService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.payload.PayloadDocumentation
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@WebMvcTest(UserController::class)
@ExtendWith(RestDocumentationExtension::class)
class UserControllerJunitTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var signUpService: SignUpService

    @MockBean
    private lateinit var refreshTokenService: RefreshTokenService

    @MockBean
    private lateinit var signInService: SignInService

    @BeforeEach
    fun setUp(
        webApplicationContext: WebApplicationContext,
        restDocumentationContextProvider: RestDocumentationContextProvider
    ) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply<DefaultMockMvcBuilder>(
                documentationConfiguration(
                    restDocumentationContextProvider
                )
            )
            .build()
    }

    @Test
    fun signUpTest() {
        mockMvc.perform(
            post("/user/register")
                .content("{\"account_id\": \"account_id\", \n\"password\": \"password\"}")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "Create User",
                    PayloadDocumentation.requestFields(
                        PayloadDocumentation.fieldWithPath("account_id").description("아이디"),
                        PayloadDocumentation.fieldWithPath("password").description("비밀번호")
                    )
                )
            )
    }

}