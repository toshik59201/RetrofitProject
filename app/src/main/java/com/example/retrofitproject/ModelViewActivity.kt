package com.example.retrofitproject

import okhttp3.OkHttpClient
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ModelViewActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        listView = findViewById(R.id.listView Data)

    override fun onResume() {
        super. onResume()
        val client = OkHttpClient()

        val request = Request.Builder()
            .get()
            .url(" https://rickandmortyapi.com/api/character ")
            .build()
        lifecycleScope.executeAsyncTask(
            onPreExecute = {
                progressBar.visibility = View.VISIBLE
            }
            doInBackground = {
                client.newCall(request).execute().use {
                    if (!it.isSuccessful)
                        return@executeAsyncTask "code: ${it.code}: ${it.message}"

                    return@executeAsyncTask it.body.string()
                }
            },
            onPostExecute = {
                try {
                    val moshi = Moshi.Builder().build()
                    val jsonAdapt = moshi.adapter(Rootobj::class.java)
                    val result = jsonAdapt.fromJson(it)
                    listView.adapter = CharacterAdapter(this@ModelViewActivity, result!!.characters)
                } catch (e: Exception) {
                    Toast.makeText(this@ModelViewActivity, it, Toast.LENGTH_SHORT).show()
                    Toast.makeText(this@ModelViewActivity, e.message, Toast.LENGTH_SHORT).show()
                } finally {
                    progressBar.setvisibility = View.GONE
                }
            }
        )

    }
}