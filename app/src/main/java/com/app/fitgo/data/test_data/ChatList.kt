package com.app.fitgo.data.test_data

import com.app.fitgo.domain.model.ChatMessage
import com.app.fitgo.domain.model.ChatUser

object ChatList {


    val chatHistory = listOf(
        ChatMessage(
            chatId = "1",
            messageId = "1",
            senderId = "sender",
            message = "Hey! How are you?",
            timestamp = "2 min", // 10 minutes ago
            isRead = true,
            isSentByUser = true,
            profileImg = "https://img.freepik.com/free-photo/portrait-hapy-young-smart-man-glasses-white-wall_231208-12206.jpg?t=st=1733386634~exp=1733390234~hmac=5a95d9553019e39e0d441c8df8db92b21447bd9e885c01d721161855d3e49732&w=360"
        ),
        ChatMessage(
            chatId = "1",
            messageId = "2",
            senderId = "receiver",
            message = "I'm good, thanks! How about you?",
            timestamp = "1 day ago", // 9.2 minutes ago
            isRead = true,
            isSentByUser = false,
            profileImg = "https://images.unsplash.com/photo-1499996860823-5214fcc65f8f?q=80&w=1366&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
        ChatMessage(
            chatId = "1",
            messageId = "3",
            senderId = "sender",
            message = "Doing well! What are you up to?",
            timestamp = "7.30 am", // 8.3 minutes ago
            isRead = true,
            isSentByUser = true,
            profileImg = "https://img.freepik.com/free-photo/portrait-hapy-young-smart-man-glasses-white-wall_231208-12206.jpg?t=st=1733386634~exp=1733390234~hmac=5a95d9553019e39e0d441c8df8db92b21447bd9e885c01d721161855d3e49732&w=360"
        ),
        ChatMessage(
            chatId = "1",
            messageId = "4",
            senderId = "receiver",
            message = "Just working on a project. You?",
            timestamp = "5 days ago", // 7.5 minutes ago
            isRead = true,
            isSentByUser = false,
            profileImg = "https://images.unsplash.com/photo-1499996860823-5214fcc65f8f?q=80&w=1366&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
        ChatMessage(
            chatId = "1",
            messageId = "5",
            senderId = "sender",
            message = "Same here! Let’s catch up later.",
            timestamp = "Just now", // 6.6 minutes ago
            isRead = false,
            isSentByUser = true,
            profileImg = "https://img.freepik.com/free-photo/portrait-hapy-young-smart-man-glasses-white-wall_231208-12206.jpg?t=st=1733386634~exp=1733390234~hmac=5a95d9553019e39e0d441c8df8db92b21447bd9e885c01d721161855d3e49732&w=360"
        ),
        ChatMessage(
            chatId = "1",
            messageId = "6",
            senderId = "receiver",
            message = "Sure thing! Let me know when you're free.",
            timestamp = "10 min", // 5.8 minutes ago
            isRead = false,
            isSentByUser = false,
            profileImg = "https://images.unsplash.com/photo-1499996860823-5214fcc65f8f?q=80&w=1366&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
        ChatMessage(
            chatId = "1",
            messageId = "7",
            senderId = "sender",
            message = "Will do. Bye for now!",
            timestamp = "2 day ago", // 5 minutes ago
            isRead = false,
            isSentByUser = true,
            profileImg = "https://img.freepik.com/free-photo/portrait-hapy-young-smart-man-glasses-white-wall_231208-12206.jpg?t=st=1733386634~exp=1733390234~hmac=5a95d9553019e39e0d441c8df8db92b21447bd9e885c01d721161855d3e49732&w=360"
        ),
        ChatMessage(
            chatId = "1",
            messageId = "8",
            senderId = "receiver",
            message = "Bye! Take care.",
            timestamp = "2 min", // 4.2 minutes ago
            isRead = false,
            isSentByUser = false,
            profileImg = "https://images.unsplash.com/photo-1499996860823-5214fcc65f8f?q=80&w=1366&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
        ChatMessage(
            chatId = "1",
            messageId = "9",
            senderId = "sender",
            message = "Thanks! You too.",
            timestamp = "1 day ago", // 3.3 minutes ago
            isRead = false,
            isSentByUser = true,
            profileImg = "https://img.freepik.com/free-photo/portrait-hapy-young-smart-man-glasses-white-wall_231208-12206.jpg?t=st=1733386634~exp=1733390234~hmac=5a95d9553019e39e0d441c8df8db92b21447bd9e885c01d721161855d3e49732&w=360"
        ),
        ChatMessage(
            chatId = "1",
            messageId = "10",
            senderId = "receiver",
            message = "😊",
            timestamp = "5.00 am", // 2.5 minutes ago
            isRead = false,
            isSentByUser = false,
            profileImg = "https://images.unsplash.com/photo-1499996860823-5214fcc65f8f?q=80&w=1366&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        ),
    )

    val chatUsers = listOf(
        ChatUser(
            chatId = "1",
            userId = "user1",
            userName = "Alice",
            profileImg = "https://img.freepik.com/free-photo/portrait-hapy-young-smart-man-glasses-white-wall_231208-12206.jpg?t=st=1733386634~exp=1733390234~hmac=5a95d9553019e39e0d441c8df8db92b21447bd9e885c01d721161855d3e49732&w=360",
            lastMessage = "Hey! Are we meeting tomorrow?",
            timestamp = "1 day ago", // 10 minutes ago
            unreadMessages = 2
        ),
        ChatUser(
            chatId = "2",
            userId = "user2",
            userName = "Bob",
            profileImg = "https://img.freepik.com/free-photo/studio-portrait-grumpy-stylish-young-man-frowns-face-with-dissatisfaction-has-bad-mood-feels-furious-annoyed-with-something_273609-8722.jpg?t=st=1733386685~exp=1733390285~hmac=63b82e4fbd1f81092d659ae909f43248f53f7a0058b6d44cc707a5a522b0f61b&w=740",
            lastMessage = "Okay, sounds good!",
            timestamp = "2 min", // 5 minutes ago
            unreadMessages = 0
        ),
        ChatUser(
            chatId = "3",
            userId = "user3",
            userName = "Charlie",
            profileImg = "https://img.freepik.com/free-photo/young-beautiful-woman-pink-warm-sweater-natural-look-smiling-portrait-isolated-long-hair_285396-896.jpg?t=st=1733386717~exp=1733390317~hmac=91b0e21411e2a6d24655c8efa0438b59ee504ca7efc3498dad9631817cff6282&w=740",
            lastMessage = "Can you send me the report?",
            timestamp = "Just now", // 15 minutes ago
            unreadMessages = 5
        ),
        ChatUser(
            chatId = "4",
            userId = "user4",
            userName = "Diana",
            profileImg = "https://img.freepik.com/free-photo/curly-man-with-broad-smile-shows-perfect-teeth-being-amused-by-interesting-talk-has-bushy-curly-dark-hair-stands-indoor-against-white-blank-wall_273609-17092.jpg?t=st=1733386746~exp=1733390346~hmac=4556b48cf86beaf428a87e5427d1c805e2e94c19506185657ad9adcb477d8360&w=740",
            lastMessage = "Thanks for your help earlier!",
            timestamp = "7 days ago", // 20 minutes ago
            unreadMessages = 1
        ),
        ChatUser(
            chatId = "5",
            userId = "user5",
            userName = "Ethan",
            profileImg = "https://img.freepik.com/free-photo/close-up-portrait-caucasian-unshaved-man-eyeglasses-looking-camera-with-sincere-smile-isolated-gray_171337-630.jpg?t=st=1733386769~exp=1733390369~hmac=1d6b0942d39ae9c7ba742c8ef3a5c4e83087c71873fe63c43a81d4eb3886833b&w=740",
            lastMessage = "Catch up soon!",
            timestamp = "7.30 am", // 7.5 minutes ago
            unreadMessages = 0
        ),
        ChatUser(
            chatId = "6",
            userId = "user6",
            userName = "Fiona",
            profileImg = "https://img.freepik.com/free-photo/handsome-unshaven-european-man-has-serious-self-confident-expression-wears-glasses_273609-17344.jpg?t=st=1733386845~exp=1733390445~hmac=8199a4930cae46517834f418ff559496c98726c8733748a2d4a5860803b1e6d8&w=740",
            lastMessage = "Let’s finalize the details later.",
            timestamp = "5 day agp", // 12 minutes ago
            unreadMessages = 3
        ),
        ChatUser(
            chatId = "7",
            userId = "user7",
            userName = "George",
            profileImg = "https://img.freepik.com/free-photo/confident-young-businessman-wearing-glasses-isolated-pink_141793-32981.jpg?t=st=1733386811~exp=1733390411~hmac=3c8ceb8afbfb06cb58614aedf4ab4efaf9161a77e7a65193e88e7bbb945963d0&w=740",
            lastMessage = "Got it, see you then!",
            timestamp = "3.15 pm", // 25 minutes ago
            unreadMessages = 0
        ),
        ChatUser(
            chatId = "8",
            userId = "user8",
            userName = "Hannah",
            profileImg = "https://img.freepik.com/free-photo/lovely-satisfied-freckled-female-with-crisp-hair-has-gentle-smile-dressed-striped-black-white-shirt-rejoices-positive-moments-life-isolated-wall-people-emotions_273609-15763.jpg?t=st=1733386785~exp=1733390385~hmac=b6360daac3b7d870008f665be4d085469faf7180eef41a3a620ce19788965c03&w=740",
            lastMessage = "Could you send me the link?",
            timestamp = "1 day ago", // 8.3 minutes ago
            unreadMessages = 2
        ),
        ChatUser(
            chatId = "9",
            userId = "user9",
            userName = "Ian",
            profileImg = "https://img.freepik.com/free-photo/portrait-young-confident-businessman-wearing-glasses_158595-5359.jpg?t=st=1733386824~exp=1733390424~hmac=e071ed05ef3cacc4d8683283323fadaabace3307414856179f72fbcc7f2ba358&w=360",
            lastMessage = "I'll call you in 5 minutes.",
            timestamp = "2 min", // 30 minutes ago
            unreadMessages = 0
        ),
        ChatUser(
            chatId = "10",
            userId = "user10",
            userName = "Julia",
            profileImg = "https://img.freepik.com/free-photo/stylish-businesswoman-with-glasses_23-2147989567.jpg?t=st=1733386867~exp=1733390467~hmac=f9a8e999b912887ce53f90a3122fb4658f42c1c1e2d3358304dc3feedbbf7589&w=740",
            lastMessage = "Happy birthday! 🎉",
            timestamp = "12 Oct 24", // 4 minutes ago
            unreadMessages = 4
        )
    )
}