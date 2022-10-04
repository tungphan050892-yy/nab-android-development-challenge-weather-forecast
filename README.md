<!-- PROJECT LOGO -->
# Readme Top
<br />
<div align="center">
  <a href="https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast">
    <img src="imgForReadmeDocs/myProfileImage.png" alt="Logo" width="120" height="120">
  </a>

<h3 align="center">NAB WEATHER FORECAST - TUNG PHAN</h3>

  <p align="center">
    My assignment to join NAB Innovation Center Vietnam
    <br />
    <a href="https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast">View Demo</a>
    ·
    <a href="https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast/issues">Report Bug</a>
    ·
    <a href="https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#main-architecture">Main Architecture</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

😎 Simple Demo Video<br><br>

[![Demo 1 Thumbnail](https://img.youtube.com/vi/1C8sPqRtsWc/0.jpg)](https://www.youtube.com/watch?v=1C8sPqRtsWc)

😎 Some feature to support text scale base on device setting and Talkback <br><br>

[![Demo 2 Thumbnail](https://img.youtube.com/vi/D-pL5n9sCGs/0.jpg)](https://www.youtube.com/watch?v=D-pL5n9sCGs)

This repository is my assignment for NAB Innovation Center Vietnam interview, I really like this assignment

Here's why:
* I do this assignment not just for the interview, but also trying to have some fun with my work.
* The assignment written clear and in detail, except that API docs is not 100% correct, so I have to clarify with HR person to clarify
* Giving me a chance to start an Android project from 0, re-approach every single topic related to mobile development in general
* This repository will be a great template to start any Android project from the beginning, with latest gradle version, lib, 3rd party, shrinkResource, minifyEnable,etc
* I also be able to learn & apply something new (heard about it but not yet have a chance for actual action on it) like accessibility in Android, security for the app in different level, etc

The project develop in a time box to fill in every requirement in the assignment, which mean the best that I can do to fit the time box, but if there's more time, I would love to:
* <b>Bug fixing:</b> there's a weird bug with Event observe, I should clean it up myself
* <b>Detect root device user</b>, I found [this](https://medium.com/mindorks/restricting-access-of-android-apps-on-root-devices-ed68055c7883) suggestion for the topic, but I didn't implement for two reasons:
+ I don't have root device to test the code in reality (actually can try to start emulator as root). But its always good to test the code in "production"
+ Time box matter force me to prioritize this topic at the end of the task list)
* Implement ui testing framework & write basic end to end test
* Adding simple build pipeline with Github Action & Deploy using Firebase App Distribution: build the app when something change on development branch, run unit test, deploy the apk file to Firebase App Distribution, send email notification to user in the list (or Slack msg if there is one)
* Support landscape mode, dim mode, dark theme
* etc

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Built With 
<b>(CLICK THE IMAGE FOR REFERENCE)</b>

* <b>Kotlin Plugin in AS version: 212-1.7.0-release-281-AS5457.46</b><br>
  <a href="https://developer.android.com/kotlin">
  <img src="https://user-images.githubusercontent.com/107334103/193745662-a6ed5049-2334-47ec-9c5b-3f806675ed78.png" height="100"/>
  </a>

* <b>Kotlin Gradle,Compiler version: 1.6.10</b><br>
  <a href="https://developer.android.com/kotlin">
  <img src="https://user-images.githubusercontent.com/107334103/193745930-bf5729da-cdac-477e-b6e3-779d579fc1b6.png" height="100"/>
  </a>

* <b>AndroidX</b><br>
  <a href="https://developer.android.com/jetpack/androidx">
  <img src="https://user-images.githubusercontent.com/107334103/193746200-61cb45c6-77eb-469a-a0f1-7b134bb7cc26.png" height="100"/>
  </a>

* <b>Other Stuff In Jetpack Compose</b><br>
  <a href="https://developer.android.com/jetpack/compose">
  <img src="https://user-images.githubusercontent.com/107334103/193746281-75753289-ef9b-4819-b183-fe62d2a67479.png" height="100"/>
  </a>

* <b>Koin</b><br>
  <a href="https://insert-koin.io/">
  <img src="https://user-images.githubusercontent.com/107334103/193746210-674d4ced-ee1d-4a16-975d-240fa2637efc.png" height="100"/>
  </a>

* <b>Firebase</b><br>
  <a href="https://firebase.google.com/">
  <img src="https://user-images.githubusercontent.com/107334103/193746392-157cd7a9-18d8-4569-b18f-4d51cfd73275.png" height="100"/>
  </a>

* <b>Android Test</b><br>
  <a href="https://developer.android.com/studio/test">
  <img src="https://user-images.githubusercontent.com/107334103/193746450-8ffa71d9-ca56-44ba-b2d2-989a29984451.png" height="100"/>
  </a>

* <b>Android Test Best Practice</b><br>
  <a href="https://developer.android.com/training/testing">
  <img src="https://user-images.githubusercontent.com/107334103/193746450-8ffa71d9-ca56-44ba-b2d2-989a29984451.png" height="100"/>
  </a>

* <b>Spotless</b><br>
  <a href="https://github.com/diffplug/spotless">
  <img src="https://user-images.githubusercontent.com/107334103/193746594-0477ed79-a136-40e9-a7c8-fb542be43ec7.png" height="100"/>
  </a>

* <b>Android Studio</b><br>
  <a href="https://developer.android.com/studio">
  <img src="https://user-images.githubusercontent.com/107334103/193745662-a6ed5049-2334-47ec-9c5b-3f806675ed78.png" height="100"/>
  </a>

* <b>Postman</b><br>
  <a href="https://www.postman.com/">
  <img src="https://user-images.githubusercontent.com/107334103/193746673-5c2179f1-a6ca-4760-9f18-eece2fb274e2.png" height="100"/>
  </a>

* <b>My Cat</b> 🐈🐈🐈🐈🐈🐈🐈<br>
  <img src="https://user-images.githubusercontent.com/107334103/193752493-a585dc15-603c-4fb8-9bc7-4e231ecc99d5.jpeg" height="300"/>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MAIN ARCHITECTURE -->
## Main Architecture
<div align="center">
    <img src="imgForReadmeDocs/mainArchitecture.png" alt="Main Architecture">
</div>

<!-- GETTING STARTED -->
## Getting Started
This is one way of how to clone this repository and run the app in debug mode

### Prerequisites

* Install Android Studio (Chipmunk 2021.2.1)
* Download android SDK Platform API level 22 to 33 (Its heavy, I know, I'm sorry but it's not my fault 😭 I blame my cat for this 🐈)
* Gradle plugin version 7.1.3
* Gradle version 7.2
* The project has jvmTarget '1.8' so make sure you have it.

### Installation

1. Get a free API Key at [https://openweathermap.org/](https://openweathermap.org/)
2. Clone the repo (I hope you already got added into the repo & setup ur ssh 😁)
   ```sh
   git clone git@github.com:tungphan050892/nab-android-development-challenge-weather-forecast.git
   ```
3. Enter your API in `local.properties`
   ```
   ONE_WEATHER_MAP_APP_ID_KEY={ENTER YOUR APPID - API KEY}
   ```
4. Sync gradle, build project using Android Studio and pray... 🙏🏽

5. Run the app

6.  if *bang* 💥, then play a mediation music 3 hours mix on youtube, and create an issue on this repository for me here [create issues](https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast/issues)
    else 🎉

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

This repository is FREE to use as a source of learning & inspiring other in Android Development Journey.
But I ENCOURAGE you to build your own base on this repository for two reasons:
- This repository is NOT a perfect repository of all time, you can surely do BETTER THAN ME!
- The most beautiful & valuable thing is you, yourself, not just the piece of work, but your entire life!

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Tung Thanh Phan - [Linkedin Profile](https://www.linkedin.com/in/phantung5892/) - phanthanhtung5892@gmail.com

Project Link: [https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast](https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Choose an Open Source License](https://choosealicense.com)
* [Robert C. Martin (“Uncle Bob”) - My Programming Uncle](http://cleancoder.com)
* [Jake Wharton - My Programming Inspirational Person](https://jakewharton.com/)
* [Google Lord](https://developers.google.com/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [My Cat](https://www.facebook.com/photo.php?fbid=7129374443799588&set=pb.100001813101292.-2207520000..&type=3)


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-url]: https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast/graphs/contributors
[forks-url]: https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast/network/members
[stars-url]: https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast/stargazers
[issues-url]: https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast/issues
[license-url]: https://github.com/tungphan050892/nab-android-development-challenge-weather-forecast/blob/development/LICENSE.txt
[linkedin-url]: https://www.linkedin.com/in/phantung5892/


