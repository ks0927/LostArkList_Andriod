# LostArkList_Andriod
저와 친구들의 로스크아크 캐릭터를 보여주는 간단한 안드로이드 어플입니다.

리사이클러뷰,웹뷰,파이어베이스를 공부하기 위한 study app

4월 10일 study: Element :RecyclerView,WebView,firebase...etc

    glide 사용해서 이미지를 가져온다
    인터넷을 통해 받아 와야해서 manifest에서 <uses-permission android:name="android.permission.INTERNET"/>로 인터넷 사용허용해야함
    
    webview
    loadurl을 통해 받아온 url을 띄워준다.
    //제작중 알게된 사실은 모바일 페이지가 따로있으면 모바일주소로 해줘야 생각한대로 되는듯함...
    //그렇게 안하면 webview가 내가 생각한 크기로 안뜨고 따로 새로운창이 뜨는것같음...
    
    recyclerview 쓸때 .notifyDataSetChanged()로 동기화 시켜주는거 잊지 말기
