package com.app.fitgo.data.test_data

import com.app.fitgo.domain.model.NotificationData
import com.app.fitgo.domain.model.PostData
import com.app.fitgo.domain.model.TrainerData

object TestingData {
    var samplePostDataLists = listOf(
        PostData(
            id = "1",
            name = "John Doe",
            content = "Every rep, every step, every drop of sweat takes you closer to your goals. Stay consistent, stay strong, and remember — progress is progress, no matter how small. 💪 #FitnessJourney #StayMotivated",
            image = "https://images.unsplash.com/photo-1601422407692-ec4eeec1d9b3?q=80&w=1450&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            profileImg = "https://images.unsplash.com/photo-1480455624313-e29b44bbfde1?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "Los Angeles, CA",
            date = "2024-11-28"
        ),
        PostData(
            id = "2",
            name = "Emma Smith",
            content = "Success doesn't come from what you do occasionally, it comes from what you do consistently. Keep pushing! 🏋️‍♂️ #DailyGrind #FitnessGoals",
            image = "https://images.unsplash.com/photo-1644492097455-d5f39f458fcd?q=80&w=1471&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            profileImg = "https://images.unsplash.com/photo-1508341591423-4347099e1f19?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "New York, NY",
            date = "2024-11-27"
        ),
        PostData(
            id = "3",
            name = "Michael Brown",
            content = "You don’t have to be great to start, but you have to start to be great. Let’s make today count! 🌟 #MotivationMonday #HealthyLifestyle",
            image = "https://images.unsplash.com/photo-1486739985386-d4fae04ca6f7?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            profileImg = "https://images.unsplash.com/photo-1552642986-ccb41e7059e7?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "Chicago, IL",
            date = "2024-11-26"
        ),
        PostData(
            id = "4",
            name = "Sophia Davis",
            content = "Consistency is the key to unlocking your potential. Stay dedicated, and the results will follow. 🔑 #WorkoutMotivation #FitLife",
            image = "https://img.freepik.com/free-photo/front-view-young-attractive-girl-blue-shirt-black-trousers-sport-outfit-doing-workouts-with-dumbells-white_140725-18390.jpg?t=st=1733375857~exp=1733379457~hmac=d29e0ea1b112703c9b46ce0f38b5d988b44908d6eba41acc983480a71d065775&w=740",
            profileImg = "https://images.unsplash.com/photo-1530882548122-0596ee66cdfd?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "Austin, TX",
            date = "2024-11-25"
        ),
        PostData(
            id = "5",
            name = "Liam Johnson",
            content = "The pain you feel today is the strength you'll feel tomorrow. Push through and never give up! 💥 #StrengthTraining #FitnessAddict",
            image = "https://images.unsplash.com/photo-1508215885820-4585e56135c8?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            profileImg = "https://images.unsplash.com/photo-1614807536394-cd67bd4a634b?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "Miami, FL",
            date = "2024-11-24"
        ),
        PostData(
            id = "6",
            name = "Olivia Wilson",
            content = "Train your mind, and your body will follow. Mental toughness is just as important as physical strength. 🧠💪 #MindsetMatters #NoExcuses",
            image = "https://images.unsplash.com/photo-1583500178450-e59e4309b57d?q=80&w=1450&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            profileImg = "https://images.unsplash.com/photo-1514626585111-9aa86183ac98?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "Seattle, WA",
            date = "2024-11-23"
        ),
        PostData(
            id = "7",
            name = "James Miller",
            content = "Every workout is progress. Celebrate the small victories because they add up to big results. 🎉 #PositiveVibes #FitnessProgress",
            image = "https://images.unsplash.com/photo-1562771379-eafdca7a02f8?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            profileImg = "https://images.unsplash.com/photo-1529111290557-82f6d5c6cf85?q=80&w=1386&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "Denver, CO",
            date = "2024-11-22"
        ),
        PostData(
            id = "8",
            name = "Ava Martinez",
            content = "Fuel your body with good food and your mind with good thoughts. A healthy outside starts from the inside. 🥗 #NutritionMatters #HealthyMind",
            image = "https://images.unsplash.com/photo-1600881333195-dbad115a6162?q=80&w=1471&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            profileImg = "https://images.unsplash.com/photo-1544005313-94ddf0286df2?q=80&w=1376&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "San Francisco, CA",
            date = "2024-11-21"
        ),
        PostData(
            id = "9",
            name = "Ethan Garcia",
            content = "Discipline is doing what needs to be done, even if you don’t feel like doing it. Let's grind! 🚀 #DisciplineEqualsFreedom #FitnessFocus",
            image = "https://plus.unsplash.com/premium_photo-1663065021874-5dec92b9134f?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            profileImg = "https://images.unsplash.com/photo-1541260894924-7ff059b93d54?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "Dallas, TX",
            date = "2024-11-20",

        ),
        PostData(
            id = "10",
            name = "Isabella Martinez",
            content = "Turn your setbacks into comebacks. You’ve got this! 🌈 #FitnessTransformation #NeverGiveUp",
            image = "https://images.unsplash.com/photo-1607962776853-346ec26811db?q=80&w=1469&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            profileImg = "https://images.unsplash.com/photo-1464863979621-258859e62245?q=80&w=1372&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            location = "Boston, MA",
            date = "2024-11-19",
        )
    )

    val trainerList = listOf(
        TrainerData(
            id = "T1",
            profileImg = "https://images.unsplash.com/photo-1519058082700-08a0b56da9b4?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            name = "Ethan Carter",
            specialty = "Strength and Conditioning Trainers",
            experience = "5 years",
            rating = 4,
            isFollowed = true
        ),
        TrainerData(
            id = "T2",
            profileImg = "https://images.unsplash.com/photo-1514626585111-9aa86183ac98?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            name = "Sophia Turner",
            specialty = "Cardio Endurance Specialists",
            experience = "3 years",
            rating = 5,
            isFollowed = false
        ),
        TrainerData(
            id = "T3",
            profileImg = "https://img.freepik.com/free-photo/front-view-young-female-with-fit-body-blue-shirt-smiling-light-white-wall_140725-59166.jpg?t=st=1733386228~exp=1733389828~hmac=6e3bb6af9a7c2bf4d717cb6610f88a9c3310222ee4314b92dcd0a436eef6db95&w=740",
            name = "Ryan Bennett",
            specialty = "Functional Fitness Trainers",
            experience = "7 years",
            rating = 1,
            isFollowed = false
        ),
        TrainerData(
            id = "T4",
            profileImg = "https://img.freepik.com/free-photo/young-sports-man-happy-expression_1194-1596.jpg?t=st=1733386252~exp=1733389852~hmac=9ecfb3b8606d2c869b9a81c555f7e15f96ef43e96f60273b25c02872b4e94338&w=740",
            name = "Isabella Clark",
            specialty = "Athletic Performance Trainers",
            experience = "2 years",
            rating = 4,
            isFollowed = false
        ),
        TrainerData(
            id = "T5",
            profileImg = "https://img.freepik.com/free-photo/young-sports-man-training-gym_1303-20718.jpg?t=st=1733386278~exp=1733389878~hmac=eb9ec46cb2e32a9040b393f51593d45fa4b797961667eb1011903b78521f48e4&w=740",
            name = "Liam Mitchell",
            specialty = "Rehabilitation and Recovery Coaches",
            experience = "10 years",
            rating = 5,
            isFollowed = false
        ),
        TrainerData(
            id = "T6",
            profileImg = "https://img.freepik.com/free-photo/handsome-man-is-engaged-gym_1157-32081.jpg?t=st=1733386302~exp=1733389902~hmac=9224262ba1916cc9a2f74ea80d6b383cfaba58d60a01769c606415f13ab6217a&w=740",
            name = "Emma Roberts",
            specialty = "Sports-Specific Trainers",
            experience = "6 years",
            rating = 4,
            isFollowed = true
        ),
        TrainerData(
            id = "T7",
            profileImg = "https://img.freepik.com/free-photo/woman-exercing-gym-holding-yoga-mat_1303-16212.jpg?t=st=1733386338~exp=1733389938~hmac=bfcdbf54be2ee6e52aba1e653da4c1e533d670f60aa7eb3b660bbd4515d69564&w=740",
            name = "Noah Wilson",
            specialty = "Flexibility and Mobility Trainers",
            experience = "4 years",
            rating = 2,
            isFollowed = false
        ),
        TrainerData(
            id = "T8",
            profileImg = "https://img.freepik.com/free-photo/happy-female-athlete-holding-exercise-mat-while-texting-mobile-phone-home_637285-6224.jpg?t=st=1733386359~exp=1733389959~hmac=2235a0c3c66d7e0a252dd77b9f29eb87ee23fe0f91ae23f50e91cc0e68716867&w=740",
            name = "Mia Anderson",
            specialty = "Group Fitness Instructors",
            experience = "8 years",
            rating = 5,
            isFollowed = false
        ),
        TrainerData(
            id = "T9",
            profileImg = "https://img.freepik.com/free-photo/young-happy-athletic-man-having-weight-training-health-club_637285-8340.jpg?t=st=1733386396~exp=1733389996~hmac=be2f8a721f223bc5c6ad784d99c620081356d1e08d8d4794c10674b033f85ddf&w=740",
            name = "Lucas Morgan",
            specialty = "Mind-Body HIT Specialists",
            experience = "1 year",
            rating = 3,
            isFollowed = false
        ),
        TrainerData(
            id = "T10",
            profileImg = "https://img.freepik.com/free-photo/front-view-young-male-athlete-sport-clothes-with-yoga-mat-pink-wall_179666-27089.jpg?t=st=1733386468~exp=1733390068~hmac=65d4bf41e4a2361a16b3b672897a7a057b8457659a18e9d85a259d6d3884537c&w=740",
            name = "Ava Hughes",
            specialty = "Weight Loss Coaches",
            experience = "9 years",
            rating = 5,
            isFollowed = false
        )
    )
}



val notificationList = listOf(
    NotificationData(
        id = "1",
        title = "Lian Carter posted a new picture",
        profileImg = "https://img.freepik.com/free-photo/medium-shot-man-with-afro-hairstyle_23-2150677136.jpg?t=st=1733391593~exp=1733395193~hmac=146e55fa629c5ae0e17ec1c0a423ae829912a936b8d986f08fa7cf615900ad5f&w=740",
        time = "Just now"
    ),
    NotificationData(
        id = "2",
        title = "John Smith commented on your photo",
        profileImg = "https://img.freepik.com/free-photo/close-up-pleasant-curly-dark-hair-female-customer-support-manager-smiling-broadly-ready-help-express-interest-happiness-grinning-white-teeth-delighted-have-positive-conversation-studio-background_176420-34934.jpg?t=st=1733391318~exp=1733394918~hmac=3639b9348d39b5ecf6c82c801ac5ee91dfec22dcdb9f4bb03e1f6224c143185f&w=740",
        time = "2:30 PM"
    ),
    NotificationData(
        id = "3",
        title = "Emily Johnson liked your post",
        profileImg = "https://img.freepik.com/free-photo/photo-pleasant-looking-girl-has-healthy-soft-skin-dark-staright-hair_273609-18461.jpg?t=st=1733391613~exp=1733395213~hmac=ce0d23454b9392b4fe0c53646043f245b85b3af056d1e9985ecbf36c38f80c66&w=740",
        time = "5 minutes ago"
    ),
    NotificationData(
        id = "4",
        title = "Michael Brown sent you a friend request",
        profileImg = "https://img.freepik.com/free-photo/young-adult-enjoying-virtual-date_23-2149328221.jpg?t=st=1733391643~exp=1733395243~hmac=248ab83817e7064c82f8e8a6ad3819426f61704ea20493a057ad947f29bb123a&w=360",
        time = "10 minutes ago"
    ),
    NotificationData(
        id = "5",
        title = "Sophia Davis shared your post",
        profileImg = "https://img.freepik.com/free-photo/good-looking-young-woman-sunglasses-smiling_176420-20749.jpg?t=st=1733391560~exp=1733395160~hmac=e42016faa7667ec652490aabe30af55b48c168a4ab5388810a231ba6ec66ecf4&w=740",
        time = "1 hour ago"
    ),
    NotificationData(
        id = "6",
        title = "William Garcia mentioned you in a comment",
        profileImg = "https://img.freepik.com/free-photo/young-woman-with-round-glasses-white-t-shirt_273609-6275.jpg?t=st=1733391697~exp=1733395297~hmac=1ce6f171092997fac74da5b7607c8c2cc961405c8d9af08c0e7039c9dae2e14a&w=740",
        time = "Yesterday"
    ),
    NotificationData(
        id = "7",
        title = "Olivia Martinez started following you",
        profileImg = "https://img.freepik.com/free-photo/young-bearded-man-with-striped-shirt_273609-5677.jpg?t=st=1733391633~exp=1733395233~hmac=3a09e9c40dbef13b724cc4bbf1f6dd679680ae2113134dd40db98f43cf38c1a9&w=740",
        time = "3 days ago"
    ),
    NotificationData(
        id = "8",
        title = "James Wilson posted a new story",
        profileImg = "https://img.freepik.com/free-photo/portrait-beautiful-redhead-woman_23-2148339229.jpg?t=st=1733391764~exp=1733395364~hmac=6c6286d4def32d295012322bd8afe839fb3e7729b7e362e7bc99204419da8808&w=360",
        time = "4:15 PM"
    ),
    NotificationData(
        id = "9",
        title = "Emma Moore updated her profile picture",
        profileImg = "https://img.freepik.com/free-photo/portrait-blonde-confident-young-businesswoman-against-gray-background_23-2148029500.jpg?t=st=1733391577~exp=1733395177~hmac=96f076ac2a1ee44d0d175ea24855fb2f821b1bce3165c3427ec465ca61b5bf08&w=360",
        time = "6 hours ago"
    ),
    NotificationData(
        id = "10",
        title = "Lucas Anderson commented on your story",
        profileImg = "https://img.freepik.com/free-photo/cute-smiling-young-man-with-bristle-looking-satisfied_176420-18989.jpg?t=st=1733391790~exp=1733395390~hmac=cd068ca56cbaae8ea295b105ef2d582a3deaa316d3f0720bd4f09059a2ea866e&w=740",
        time = "11:00 AM"
    )
)



