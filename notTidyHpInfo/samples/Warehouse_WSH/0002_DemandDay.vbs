'///////////////////////////////////////////////////////////
'//
'//      ���t����͂��ėj�������߂�
'//
Option Explicit
Dim hizuke, youbi

Do
    '//���t����͂��邽�߂̃C���v�b�g�{�b�N�X��\��
    hizuke = InputBox("���ɂ�����͂��ėj���𒲂ׂ܂��B" &_
        vbCR & vbCR &_
        "��j2000/01/01" & vbCR &_
        "    11-11" & vbCR &_
        "    h15-5-5","�j���𒲂ׂ�")
        
    '//�u�L�����Z���v�܂��͖����͂ŏI��
    If hizuke = "" Then
        Exit Do
        
    '//���t�������炻�̗j����\��
    ElseIf IsDate(hizuke) then
        youbi = Weekday(hizuke)
        MsgBox WeekdayName(youbi) & "�ł��B",64
        
    '//���t�łȂ�������A���ӂ�\�����āA�C���v�b�g�{�b�N�X�ɖ߂�
    Else
        MsgBox "���͂����l���s���ł��B",48
    End If
    
Loop