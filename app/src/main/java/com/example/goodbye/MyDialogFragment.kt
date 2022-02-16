package com.example.goodbye

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class MyDialogFragment : DialogFragment() {
    //override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        /*return activity?.let{
            val builder = AlertDialog.Builder(it)*/
            /*builder.setTitle("Важиве повідомлення")
                .setMessage("Нагодуйте кота!")
                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton("Добре, йду на кухню!"){
                    dialog, id -> dialog.cancel()
                }
            builder.create()
        }?:throw IllegalStateException("Activity cannot be null")
    }*/
    /*private val catNames = arrayOf("Васька","Рижик","Мурзик")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val selectedItems = ArrayList<Int>()
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Выберіть улюблене ім'я кота")
                .setSingleChoiceItems(catNames, -1
                ) { dialog, item ->
                    Toast.makeText(activity, "Улюблене ім'я кота:  ${catNames[item]}",
                        Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("OK"
                ) { dialog, id ->
                    // User clicked OK, so save the selectedItems results somewhere
                    // or return them to the component that opened the dialog
                }
                .setNegativeButton("Відміна") {
                        dialog, id ->
                }*/







        /*return activity?.let{
                    val builder = AlertDialog.Builder(it)
                    builder.setTitle("Вибір є завжди")
                        .setMessage("Выберіть їжу")
                        .setCancelable(true)
                        .setPositiveButton("Смачна їжа") { dialog, id ->
                            Toast.makeText(activity, "Ви зробили правильний вибір",
                                Toast.LENGTH_LONG).show()
                        }
                        .setNegativeButton("Здоровая їжа",
                            DialogInterface.OnClickListener { dialog, id ->
                                Toast.makeText(activity, "Можливо, ви праві",
                                    Toast.LENGTH_LONG).show()
                            })
                    builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }*/
      /*  return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Виберіть правильну відповідь")
                .setCancelable(true)
                .setPositiveButton("Мяу")  { dialog, id -> dialog.cancel() }
            .setNeutralButton("Гав")  { dialog, id -> dialog.cancel() }
            .setNegativeButton("Сам дурень!")  { dialog, id -> dialog.cancel() }*/


    private val catNames = arrayOf("Васька", "Рижик", "Мурзик")
    private val checkedItems = booleanArrayOf(false, true, false)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Виберіть котiв")
                .setMultiChoiceItems(catNames, checkedItems) {
                        dialog, which, isChecked ->
                    checkedItems[which] = isChecked
                    val name = catNames[which] // Get the clicked item
                    Toast.makeText(activity, name, Toast.LENGTH_LONG).show()
                }
                .setPositiveButton("Готово"
                ) {
                        dialog, id ->
                    // User clicked OK, so save the selectedItems results somewhere
                    for (i in catNames.indices) {
                        val checked = checkedItems[i]
                        if (checked) {
                            Log.i("Dialog", catNames[i])
                        }
                    }
                }
                .setNegativeButton("Відміна") {
                        dialog, _ ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}




