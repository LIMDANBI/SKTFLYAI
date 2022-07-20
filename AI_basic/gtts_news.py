from gtts import gTTS
import playsound

drama = input("드라마 제목은? ")
category = input("드라마 방영 요일은? ")
day = input("드라마 방영 일자는? ")
episode = input("드라마 회차는? ")
viewer_ratings = float(input("이번 회차 시청률은? "))
before_viewer_ratings = float(input("지난 회차 시청률은? "))

news= "[종합]{} {}회".format(drama, episode)

if before_viewer_ratings < viewer_ratings:
    news += "\n {}드라마 '{}'의 {}회 시청률이 지난 시청률 {}% 대비 {}% 상승한 {}%로 나타났다.".format(category, drama, episode, before_viewer_ratings, viewer_ratings-before_viewer_ratings, viewer_ratings)
elif before_viewer_ratings == viewer_ratings:
    news += "\n {}드라마 '{}'의 {}회 시청률이 지난 시청률과 같은 {}%로 나타났다.".format(category, drama, episode, viewer_ratings)
else: 
    news += "\n {}드라마 '{}'의 {}회 시청률이 지난 시청률 {}% 대비 {}% 하락한 {}%로 나타났다.".format(category, drama, episode, before_viewer_ratings, before_viewer_ratings-viewer_ratings, viewer_ratings)
    
print(news)
tts = gTTS(text=news, lang='ko')
tts.save('./news_voice.mp3')