'///////////////////////////////////////////////////////////
'//
'//      日付を入力して曜日を求める
'//
Option Explicit
Dim hizuke, youbi

Do
    '//日付を入力するためのインプットボックスを表示
    hizuke = InputBox("日にちを入力して曜日を調べます。" &_
        vbCR & vbCR &_
        "例）2000/01/01" & vbCR &_
        "    11-11" & vbCR &_
        "    h15-5-5","曜日を調べる")
        
    '//「キャンセル」または未入力で終了
    If hizuke = "" Then
        Exit Do
        
    '//日付だったらその曜日を表示
    ElseIf IsDate(hizuke) then
        youbi = Weekday(hizuke)
        MsgBox WeekdayName(youbi) & "です。",64
        
    '//日付でなかったら、注意を表示して、インプットボックスに戻る
    Else
        MsgBox "入力した値が不正です。",48
    End If
    
Loop