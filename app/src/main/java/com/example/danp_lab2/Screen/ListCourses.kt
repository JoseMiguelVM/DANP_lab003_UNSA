package com.example.danp_lab2.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.danp_lab2.HomeViewModel
import com.example.danp_lab2.R
import com.example.danp_lab2.data.Course

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LisCourses(viewModel: HomeViewModel) {

    var listStudent = viewModel.getAllStudent().observeAsState().value
    var listCourse = viewModel.getAllCourse().observeAsState().value
    var listStudentCourseCrossRef = viewModel.getAllStudentCourseCrossRef().observeAsState().value

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), verticalArrangement = Arrangement.Center) {
        item {

            Image(
                painter = painterResource(R.drawable.school),
                contentDescription = "Descripción de la imagen",
                modifier = Modifier.size(100.dp),
            )

            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "Matriculados",
                textAlign = TextAlign.Center,
                modifier = Modifier.width(190.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(26.dp))
        }
        if (listStudent != null && listCourse != null && listStudentCourseCrossRef != null) {
            listCourse.forEach {
                var aux = it
                item {
                    Row() {
                        Text(text = it.courseName + " : ")
                        listStudent.forEach {
                            var aux2 = it
                            listStudentCourseCrossRef.forEach {
                                if (it.courseId == aux.courseId && it.studentId == aux2.studentId) {
                                    Text(text = " "+aux2.studentName)
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}




