package org.example;

import java.util.*;


public class dataBase {
    public HashMap<String, String[]> ideaLibrary = new HashMap<>();
    static ArrayList<String[]> synonym = new ArrayList<>();

    public dataBase() {
        ideaLibrary.put("securityIdeas", securityIdeas);
        ideaLibrary.put("web Develop", webDevelopmentIdeas);
        ideaLibrary.put("app", appIdeas);
        ideaLibrary.put("program", programIdeas);
        ideaLibrary.put("mobile app", mobileIdeas);
        ideaLibrary.put("desktop app", desktopIdeas);
        ideaLibrary.put("database programming", databaseProgrammingIdeas);
        ideaLibrary.put("artificial intelligence", aiIdeas);
        synonym.add(webDevSynonyms);
        synonym.add(appSynonyms);
        synonym.add(securityProgrammingSynonyms);
        synonym.add(programmingSynonyms);
        synonym.add(databaseSynonyms);
        synonym.add(aiSynonyms);
        synonym.add(mobileAppSynonyms);
        synonym.add(desktopAppSynonyms);
    }
    String[] webDevSynonyms = {"web engineering", "web application development", "web programming", "web design and development", "web software development", "web systems development", "web development framework", "full stack web development", "back-end web development", "front-end web development"};
    String[] appSynonyms = {"application", "mobile application", "applet", "program", "software", "tool", "utility", "solution", "platform", "system"};
    String[] securityProgrammingSynonyms = {"secure coding", "secure development", "secure software engineering", "secure app development", "secure web programming", "secure scripting", "secure coding practices", "defensive programming", "software security engineering", "code hardening"};
    String[] programmingSynonyms = {"coding", "software development", "scripting", "algorithm design", "application development", "computer programming", "source code authoring", "programming language usage", "code writing", "software engineering"};
    String[] databaseSynonyms = {"data management", "database design", "data modeling", "data warehousing", "database administration", "data manipulation", "database optimization", "data mining", "data analysis", "database security"};
    String[] aiSynonyms = {"ai","artificial intelligence", "machine intelligence", "cognitive computing", "autonomous systems", "robotics", "intelligent machines", "smart systems", "neural networks"};
    String[] mobileAppSynonyms = {"smartphone applications", "mobile applications", "mobile software", "mobile programs", "mobile tools", "handheld apps", "wireless apps", "cell phone apps", "portable applications", "pocket programs"};
    String[] desktopAppSynonyms = {"computer programs", "software applications", "PC apps", "workstation software", "computer tools", "personal computer software", "desktop software", "computer utilities", "PC applications", "computer applications"};

    // جمل افتتاحية للبرنامج
    String[] statementStarters = {
            "Here is an idea:",
            "Check this:",
            "Hmm i found this:",
            "Have you thought about:",
            "How about:",
            "This could be worth trying:",
            "I came across this:",
            "We could potentially:",
            "I found this is interesting:",
            "Here's something to consider:",
            "Let's brainstorm:",
            "Here's an intriguing thought:",
            "Maybe this help you:",
            "This idea could be promising:",
    };
    public String getStatementStarters(){
        int randomIndex = (int) (Math.random() * statementStarters.length);
        return statementStarters[randomIndex]+" ";
    }
        //راح يبحث عن الفيلد 
    public String getAnswer(String input){
        String[] x = findBestMatch(input);
        Random rand = new Random();
        int randNum = rand.nextInt(synonym.size());

        try {
            return x[randNum-1];
        } catch (IndexOutOfBoundsException e) {
            // Handle the exception
            System.out.println("Error: " + e.getMessage());
            return x[6]; // or return a default value or do something else to handle the error
        }
    }
    // هنا هو يقارن ايش اقرب مجال لسؤال المستخدم
    public String[] findBestMatch(String query) {
        query = query.toLowerCase();
        String[] input = query.split(" ");
        String bestMatch = ""; //no use
        int highestScore = 0;
        String[] list = null;
        for(String usInput : input) {
            for (String[] option : synonym) {
                for (String word : option) {
                    if (word.toLowerCase().contains(usInput.toLowerCase())) {
                        int score = calculateScore(query, word);
                        if (score > highestScore) {
                            bestMatch = word; // no use
                            highestScore = score;
                            list = option;
                        }
                    }
                }
            }
        }
        return list;
    }
    //هذه عمليات حسابية يقارن فيها ايهم اقرب للاجابة
    private static int calculateScore(String query, String option) {
        int score = 0;
        int maxScore = Math.min(query.length(), option.length());
        for (int i = 0; i < maxScore; i++) {
            if (query.charAt(i) == option.charAt(i)) {
                score++;
            }
        }
        return score;
    }
    // هنا الكلمات اللي توقعت انه المستخدم يكتبها سواءً اذا سال او طلب الخ.. او حط كلمة مفتاحية عبارة عن مشروع او فكرة
    private static final String[] xxx = {"want to", "want", "would like to", "desire to", "intend to", "intend", "want to", "want", "would like to", "desire", "intend", "want to", "want", "would like to", "crave", "yearn", "hunger for", "covet", "long for", "hanker after", "thirst for", "itch for", "pine for", "seek", "search for", "look for", "hunt for", "pursue", "strive for", "aspire to", "aim for", "covet", "desiderata", "fancy", "hanker", "need", "require", "wish for", "have need of", "enquire", "ask", "inquire", "question", "interrogate", "probe", "query", "quiz", "grill", "cross-examine", "pump", "dig", "solicit", "entreat", "beg", "beseech", "implore", "plead with", "request", "appeal to", "importune", "press", "demand", "require", "insist on", "direct", "enjoin", "command", "order", "tell", "expect", "count on", "hope for", "trust in", "rely on", "bank on", "depend on", "believe", "be confident", "have faith", "assume", "presume", "take for granted", "suppose", "conjecture", "speculate", "theorize", "hypothesize", "postulate", "surmise", "guess", "estimate", "reckon", "calculate", "count", "evaluate", "assess", "appraise", "rate", "judge", "conclude", "infer", "deduce", "derive", "gather", "assume", "presuppose", "imagine", "conceive of", "envision", "picture", "visualize", "see in one's mind's eye", "dream of", "fantasize about", "delude oneself", "kid oneself", "fool oneself", "trick oneself", "deceive oneself", "mislead oneself", "hoodwink oneself", "bamboozle oneself", "dupe oneself", "delude", "mislead", "trick", "deceive", "lead astray", "beguile", "misinform", "misguide", "take in", "pull the wool over someone's eyes", "put one over on", "play false", "play a trick on", "play a joke on", "play a prank on", "play a game with", "play a trick upon", "put someone up to something", "induce", "persuade", "convince", "coax", "cajole", "wheedle", "entice", "lure", "seduce", "tempt", "attract", "draw", "allure", "charm", "fascinate", "captivate", "enchant", "bewitch", "mesmerize", "hypnotize", "spellbind", "galvanize", "inspire", "motivate", "encourage", "stimulate", "spur", "arouse", "excite", "incite", "provoke", "routs", "awaken", "kindle", "ignite", "fire up", "stoke up", "stir up", "fan the flames", "set off", "trigger", "spark", "activate", "animate", "invigorate", "vitalize", "revitalize", "reinvigorate"};
    public static ArrayList<String> askSynonyms = new ArrayList<>(Arrays.asList(xxx));

    private static final String[] yyy = {"ideas", "projects", "concepts", "initiative", "venture", "scheme", "undertaking", "enterprise", "endeavor", "pursuit", "plan", "proposal", "strategy", "program", "design", "system", "approach", "innovation", "invention", "creation", "brainchild", "conception", "vision", "brainwave", "inspiration", "concept", "notion", "thought", "scheme", "arrangement", "blueprint", "outline", "draft", "sketch", "model", "prototype", "mock-up", "sample", "version", "iteration", "variation", "adaptation", "improvement", "development", "evolution", "advancement", "progress", "growth", "expansion", "expansionism", "escalation", "amplification", "enlargement", "extension", "widening", "broadening", "spreading", "outreach", "outward", "projection", "manifestation", "expression", "representation", "realization", "actualization", "accomplishment", "achievement", "fulfillment", "attainment", "success", "triumph", "victory", "conquest", "realized", "implementing", "putting into practice", "executing", "carrying out", "enacting", "enforcing", "applying", "using", "utilizing", "employing", "harnessing", "leveraging", "exploiting", "capitalizing on", "maximizing", "optimizing", "improvising", "innovating", "improving", "enhancing", "boosting", "increasing", "strengthening", "consolidating", "solidifying", "bolstering", "fortifying", "supporting", "backing", "endorsing", "advocating", "promoting", "facilitating", "enabling", "allowing", "permitting", "authorizing", "sanctioning", "approving", "endorsing", "ratifying", "certifying", "accrediting", "validating", "affirming", "confirming", "attesting", "proving", "demonstrating", "showing", "evidencing"};
    public static ArrayList<String> ideas = new ArrayList<>(Arrays.asList(yyy));

    public static final String[] topicsField = { // no use
            "computer", "programming", "apps", "software", "technology"
    };
    // هنا خزنت الافكار
    public static String[] webDevelopmentIdeas = {
            "Create a responsive website for a small business",
            "Build an e-commerce website for a local store",
            "Create a custom WordPress theme",
            "Design a landing page for a mobile app",
            "Develop a web-based project management tool",
            "Create an online booking system for a hotel",
            "Build a website for a non-profit organization",
            "Develop a social networking website for a niche community",
            "Design a website for an online course or tutorial",
            "Create an online forum for a particular interest group",
            "Build a web-based document management system",
            "Develop a responsive website for a news or blog site",
            "Design a website for a travel agency",
            "Create an online store for a specialty retailer",
            "Build a web-based survey or polling tool",
            "Develop a virtual event platform for live online events",
            "Design a website for a local government or municipality",
            "Create a web-based appointment booking system",
            "Build an online portfolio for an artist or photographer",
            "Develop a web-based time tracking tool",
            "Design a website for a restaurant or food delivery service",
            "Create an online booking system for a transportation service",
            "Build a web-based customer support system",
            "Develop a web-based task management tool",
            "Design a website for a real estate agency",
            "Create an online marketplace for a particular industry",
            "Build a web-based data visualization tool",
            "Develop a web-based game or interactive experience",
            "Design a website for a sports team or league",
            "Create an online reservation system for a rental service",
            "Build a web-based fitness or workout tracker",
            "Develop a web-based chat or messaging system",
            "Design a website for a music artist or band",
            "Create a web-based tool for organizing and managing bookmarks",
            "Build a website for a political campaign or advocacy group",
            "Develop a web-based invoice or billing system",
            "Design a website for a language learning service",
            "Create an online donation platform for a non-profit organization",
            "Build a web-based social media dashboard",
            "Develop a web-based file sharing or collaboration tool",
            "Design a website for a beauty or fashion brand",
            "Create an online survey or quiz tool",
            "Build a web-based job search or recruitment platform",
            "Develop a web-based weather or environmental data visualization tool",
            "Design a website for a tech startup or innovation lab",
            "Create an online personal finance management tool",
            "Build a web-based platform for hosting and sharing digital content",
            "Develop a web-based reminder or scheduling tool",
            "Design a website for a law firm or legal services provider",
            "Create an online rental platform for specialty equipment or services",
            "Build a web-based photo editor or image processing tool",
            "Develop a web-based document translation or language learning tool",
            "Design a website for a health or wellness app care"
    };
    public static String[] desktopIdeas = {
            "A video editing tool",
            "A music player with advanced playlist management",
            "A productivity app that blocks distracting websites",
            "A password manager with multiple encryption options",
            "A simple note-taking application",
            "A file compression tool",
            "A lightweight image viewer and editor",
            "An app that allows you to create and organize bookmarks",
            "A disk space analyzer and cleanup tool",
            "A personal finance management app",
            "A utility that lets you quickly access frequently-used files and folders",
            "A weather app with live updates and customizable notifications",
            "A screen capture and recording tool",
            "A calendar and scheduling app",
            "A web browser with advanced privacy and security features",
            "A file syncing tool for cloud storage services",
            "An ebook reader with customizable themes and reading settings",
            "A to-do list app with advanced organization and sorting options",
            "A project management tool with task delegation and progress tracking",
            "A database management app with customizable schema",
            "A remote desktop client for easy access to other computers",
            "A text editor with syntax highlighting and code completion",
            "A system optimizer and cleanup tool",
            "An email client with advanced filtering and sorting options",
            "A screenshot comparison tool for web designers",
            "A tool for managing and organizing your digital photos",
            "A file and folder comparison utility",
            "A 3D modeling and design tool",
            "A system backup and restore utility",
            "An app for managing and organizing your music library",
            "A code version control tool",
            "An antivirus and malware removal tool",
            "A tool for creating and managing custom keyboard shortcuts",
            "A lightweight media player with support for a wide range of file types",
            "A disk partition and management utility",
            "A tool for organizing and managing contacts",
            "A network monitoring and analysis tool",
            "A calculator with advanced scientific functions",
            "A chat client for connecting with friends and colleagues",
            "A system tray utility for quick access to frequently-used tools",
            "A utility for managing and organizing your ebook collection",
            "A tool for managing and organizing your video library",
            "A tool for managing and organizing your photo library",
            "A file recovery tool for retrieving deleted files",
            "A personal journaling and diary app",
            "A tool for creating and managing backups of your important files",
            "A tool for monitoring and optimizing system performance",
            "A tool for managing and organizing your book collection",
            "A tool for managing and organizing your movie collection",
            "A tool for managing and organizing your comic book collection",
            "A tool for creating and managing custom desktop wallpapers",
            "An audio editing tool with support for multiple tracks and effects",
            "A tool for organizing and managing recipes",
            "A tool for creating and managing custom icons and graphics",
            "A tool for monitoring and analyzing internet traffic",
            "A tool for organizing and managing digital documents",
            "A tool for creating and managing custom mouse gestures",
            "A tool for managing and organizing your stamp collection",
            "A tool for managing and organizing your coin collection",
            "A tool for creating and managing custom sound effects",
            "A tool for creating and managing custom ringtones",
            "A tool for monitoring and optimizing computer temperatures",
            "A tool for creating and managing custom desktop widgets",
            "A tool for managing and organizing your wine collection",
            "A tool for managing and organizing your beer collection",
            "A tool for creating and managing custom user interfaces"
    };
    public static String[] databaseProgrammingIdeas = {
            "Design a database schema for a social media platform",
            "Implement a data access layer for an e-commerce website",
            "Build a database to store and manage customer data for a subscription service",
            "Create a system to track inventory levels and sales data for a retail business",
            "Develop a database to manage patient records for a healthcare provider",
            "Design a database to store and track employee performance data for a human resources department",
            "Build a system to manage and store financial transactions for a banking institution",
            "Develop a database to store and analyze website traffic data for a digital marketing agency",
            "Design a database to manage and track customer service requests for a support team",
            "Build a system to store and manage product data for an online marketplace",
            "Develop a database to track and analyze user behavior for a web application",
            "Design a database to store and manage metadata for a large-scale file storage system",
            "Build a system to manage and store data for scientific research studies",
            "Develop a database to store and manage medical records for a hospital or clinic",
            "Design a database to store and manage student records for an educational institution",
            "Build a system to store and manage customer relationship data for a sales team",
            "Develop a database to store and manage shipping and logistics data for a transportation company",
            "Design a database to store and manage employee benefits data for a human resources department",
            "Build a system to store and manage property data for a real estate agency",
            "Develop a database to store and manage ticket sales data for an event management company",
            "Design a database to store and manage project data for a software development team",
            "Build a system to store and manage financial data for an accounting firm",
            "Develop a database to store and manage inventory data for a manufacturing company",
            "Design a database to store and manage supply chain data for a distribution company",
            "Build a system to store and manage patient health data for a telemedicine platform",
            "Develop a database to store and manage customer billing data for a utility company",
            "Design a database to store and manage flight data for an airline",
            "Build a system to store and manage data for a non-profit organization",
            "Develop a database to store and manage data for a political campaign",
            "Design a database to store and manage weather data for a meteorological agency",
            "Build a system to store and manage data for a sports league",
            "Develop a database to store and manage data for a public transportation system",
            "Design a database to store and manage energy usage data for a utility company",
            "Build a system to store and manage data for an insurance company",
            "Develop a database to store and manage data for a research organization",
            "Design a database to store and manage data for a government agency",
            "Build a system to store and manage data for a news organization",
            "Develop a database to store and manage data for a hotel or hospitality company",
            "Design a database to store and manage data for a casino or gaming company",
            "Build a system to store and manage data for a law firm",
            "Develop a database to store and manage data for a museum or art gallery",
            "Design a database to store and manage data for a fashion or apparel company",
            "Build a system to store and manage data for a food or beverage company",
            "Develop a database to store and manage data for a travel or tourism company",
            "Design a database to store and manage data for a religious organization",
    };
    public static String[] mobileIdeas = {
            "Create a mobile app for tracking water intake",
            "Develop a mobile app for meditation and mindfulness",
            "Build an app for creating custom workouts and exercise plans",
            "Develop a mobile app for language learning",
            "Create a mobile game for learning and practicing new skills",
            "Build an app for finding and booking local activities and events",
            "Develop a mobile app for managing personal finances",
            "Create a mobile app for tracking mood and mental health",
            "Build an app for discovering new recipes and meal planning",
            "Develop a mobile app for creating and sharing travel itineraries",
            "Create a mobile app for booking and managing appointments with healthcare providers",
            "Build an app for sharing and discovering hiking and outdoor trails",
            "Develop a mobile app for connecting with local volunteer opportunities",
            "Create a mobile app for tracking and improving sleep habits",
            "Build an app for tracking and reducing screen time",
            "Develop a mobile app for organizing and managing to-do lists and tasks",
            "Create a mobile app for finding and sharing book recommendations",
            "Build an app for tracking and reducing carbon footprint",
            "Develop a mobile app for creating and sharing art and design projects",
            "Create a mobile app for discovering and booking pet-friendly travel options",
            "Build an app for tracking and reducing food waste",
            "Develop a mobile app for learning and practicing new musical skills",
            "Create a mobile app for finding and booking local classes and workshops",
            "Build an app for tracking and reducing water waste",
            "Develop a mobile app for tracking and improving posture and ergonomics",
            "Create a mobile app for discovering and booking eco-friendly travel options",
            "Build an app for finding and booking local pet care services",
            "Develop a mobile app for tracking and reducing energy consumption",
            "Create a mobile app for discovering and sharing local art and cultural events",
            "Build an app for tracking and reducing plastic waste",
            "Develop a mobile app for creating and sharing digital art and design projects",
            "Create a mobile app for finding and sharing gardening tips and resources",
            "Build an app for tracking and reducing paper waste",
            "Develop a mobile app for connecting with local animal rescue and adoption services",
            "Create a mobile app for discovering and sharing local food and drink events",
            "Build an app for tracking and reducing clothing waste",
            "Develop a mobile app for tracking and reducing household waste",
            "Create a mobile app for finding and sharing eco-friendly products and services",
            "Build an app for tracking and reducing transportation emissions",
            "Develop a mobile app for creating and sharing digital music projects",
            "Create a mobile app for discovering and booking local outdoor adventures",
            "Build an app for tracking and reducing household energy consumption",
            "Develop a mobile app for connecting with local community service organizations",
            "Create a mobile app for finding and sharing sustainable fashion resources",
            "Build an app for tracking and reducing water pollution",
            "Develop a mobile app for discovering and booking sustainable travel options",
            "Create a mobile app for finding and sharing local farmers markets and CSA programs",
            "Build an app for tracking and reducing food packaging waste",
            "Develop a mobile app for connecting with local outdoor and environmental groups",
            "Create a mobile app for discovering and booking local eco-friendly accommodations",
            "Build an app for tracking and reducing water usage in landscaping and gardening",
            "Develop a mobile app for creating and sharing digital writing projects"
    };
    public static String[] aiIdeas = {
// generate ideas
    "Develop a chat-bot for customer support using natural language processing (NLP)",
    "Build a recommendation engine using collaborative filtering",
    "Create a fraud detection system using machine learning",
    "Develop a sentiment analysis tool for social media monitoring",
    "Build a predictive maintenance system for industrial equipment",
    "Create a speech recognition system for a virtual assistant",
    "Develop an image recognition system for detecting and classifying objects",
    "Build a personalized recommendation system for e-commerce",
    "Create a self-driving car using deep learning algorithms",
    "Build a recommendation system for movies and TV shows using content-based filtering",
    "Develop a fraud detection system for credit card transactions using anomaly detection",
    "Create a natural language processing system for summarizing news articles",
    "Build a predictive model for loan approvals using historical data",
    "Develop a deep learning model for image generation and synthesis",
    "Create a system for detecting fake news using machine learning",
    "Build a recommendation system for music using collaborative filtering",
    "Develop a facial recognition system for security and surveillance",
    "Create a speech-to-text system for transcribing audio recordings",
    "Build a system for classifying customer complaints and routing them to the appropriate department",
    "Develop a model for predicting stock prices using historical data",
    "Create a recommendation system for books using collaborative filtering",
    "Build a system for detecting and preventing cyber attacks using machine learning",
    "Develop a natural language processing system for language translation",
    "Create a model for predicting customer churn in a subscription-based business",
    "Build a system for diagnosing medical conditions using image recognition",
    "Develop a model for predicting real estate prices based on historical data",
    "Create a system for detecting and preventing credit card fraud using machine learning",
    "Build a recommendation system for recipes using collaborative filtering",
    "Develop a chat-bot for mental health counseling using natural language processing",
    "Create a system for analyzing social media sentiment for marketing insights",
    "Build a model for predicting weather patterns using historical data",
    "Develop a system for detecting and preventing shoplifting using computer vision",
    "Create a recommendation system for podcasts using collaborative filtering",
    "Build a system for detecting and preventing money laundering using machine learning",
    "Develop a model for predicting customer lifetime value in a subscription-based business",
    "Create a system for detecting and preventing insider trading using machine learning",
    "Build a recommendation system for wines using collaborative filtering"
};

    public static final String[] securityIdeas = {
            "A password manager application",
            "A two-factor authentication app",
            "A network security tool",
            "A VPN app for secure browsing",
            "A firewall for home networks",
            "A security audit tool for websites",
            "An encryption tool for sensitive files",
            "A secure file sharing and collaboration platform",
            "A tool to detect and block phishing attempts",
            "A security awareness training program for employees"
    };
    public static final String[] appIdeas = {
            "A mindfulness and meditation app",
            "A recipe and meal planning app",
            "A fitness tracking app",
            "A language learning app",
            "A virtual reality travel app",
            "A personal finance app",
            "A local events and activities app",
            "A virtual interior design app",
            "A plant care app",
            "A mental health and well-being app"
    };
    public static final String[] programIdeas = {
            "A code editor that can suggest and auto-complete code snippets for faster and more efficient coding.",
            "A version control system for managing and tracking changes in code repositories.",
            "An application that helps developers learn new programming languages through interactive tutorials and exercises.",
            "A bug tracker to help identify and fix errors in code more efficiently.",
            "A web framework that makes it easy to build and deploy web applications.",
            "A package manager for easily downloading, installing and managing libraries and dependencies in your projects.",
            "A code generator that can automatically create code based on templates, saving time and effort for developers.",
            "A tool that checks code quality and performance, making suggestions for improvement.",
            "A platform for hosting and sharing open-source projects, with features like issue tracking, pull requests and wikis.",
            "A continuous integration and deployment system that helps automate the software development process and streamline the release process.",
            "A basic calculator application.",
            "A to-do list manager with added features like categorization and due dates.",
            "A personal finance manager to track income and expenses.",
            "A weather application that displays current weather and forecasts for a given location.",
            "A student grade book application to store and calculate grades for multiple classes.",
            "A program to manage a library's collection, including checking out and returning books.",
            "A recipe manager to store, organize and search for recipes.",
            "A program to simulate a basic e-commerce store, including products, shopping cart, and checkout process.",
            "A program that creates a random maze and solves it using a pathfinding algorithm.",
            "A program to manage and organize your personal contacts and addresses.",
            "A program to play and manage a collection of your favorite songs and playlists.",
            "A program to manage a virtual pet, with features like feeding, playing, and health tracking.",
            "A program to track and manage your personal fitness goals and progress.",
            "A program to manage and organize your movie collection, including ratings and reviews.",
            "A program to manage and book appointments with a service provider, such as a doctor or hair stylist.",
            "A program to play and manage a collection of your favorite games, including tracking high scores and progress.",
            "A program to simulate a bank account, including deposits, withdrawals, and account balance tracking.",
            "A program to manage and organize your personal book collection, including ratings and reviews.",
            "A program to simulate a basic chatroom, allowing multiple users to send and receive messages in real-time.",
            "A program to manage and organize your personal task list and to-do items, with features like priority levels and due dates.",
            "A program to play and manage a collection of your favorite TV shows and movies, including tracking progress and watching history.",
            "A program to manage and track your personal nutrition, including logging meals and calculating calorie intake.",
            "A program to manage and organize your personal travel itinerary, including flights, hotels, and activities.",
            "A program to play and manage a collection of your favorite video games, including tracking progress and completion.",
            "A program to manage and organize your personal collection of digital photos, including tagging and categorization.",
            "A program to simulate a virtual store, including browsing products, adding to cart, and checkout process.",
            "A program to manage and track your personal reading list and books, including tracking progress and review.",
            "A program to simulate a basic social media platform, including posting, commenting, and likes.",
            "A program to manage and organize your personal collection of music, including albums, artists, and playlists.",
            "A program to manage and track your personal goal setting and progress, including creating, tracking, and reflecting on goals."
    };

    private static final String[] errorMessages = {
            "Invalid input format. Please try again.",
            "Input format error.",
            "Oops! Invalid input.",
            "Whoops! Invalid input format.",
            "Error! Invalid input.",
            "Incorrect input format.",
            "Wrong input format.",
            "Invalid input detected.",
            "Sorry, but that input is invalid. Please try again.",
    };
    // هذا ميثود يرجع للمستخدم رسالة خطأ عشوائية ومختلفة عن كل مره تقريباً
    public void getErrorMessages(){
        int randomIndex = (int) (Math.random() * errorMessages.length);
        System.out.println(errorMessages[randomIndex]);
    }

    //dev mode

    public void setWebDevSynonyms(String[] webDevSynonyms) {
        this.webDevSynonyms = webDevSynonyms;
    }

    public void setAppSynonyms(String[] appSynonyms) {
        this.appSynonyms = appSynonyms;
    }

    public void setSecurityProgrammingSynonyms(String[] securityProgrammingSynonyms) {
        this.securityProgrammingSynonyms = securityProgrammingSynonyms;
    }

    public void setProgrammingSynonyms(String[] programmingSynonyms) {
        this.programmingSynonyms = programmingSynonyms;
    }

    public void setDatabaseSynonyms(String[] databaseSynonyms) {
        this.databaseSynonyms = databaseSynonyms;
    }

    public void setAiSynonyms(String[] aiSynonyms) {
        this.aiSynonyms = aiSynonyms;
    }

    public void setMobileAppSynonyms(String[] mobileAppSynonyms) {
        this.mobileAppSynonyms = mobileAppSynonyms;
    }

    public void setDesktopAppSynonyms(String[] desktopAppSynonyms) {
        this.desktopAppSynonyms = desktopAppSynonyms;
    }

    public void setStatementStarters(String[] statementStarters) {
        this.statementStarters = statementStarters;
    }
    //TODO: save the data into a file then read file every time program run [IMPORTANT]
    // هنا عشان اذا المستخدم يبغى يطور البرنامج بحيث يضيف كلمات عشان يساعد البرنامج انه يفهم اكثر
    public static void addAskSynonyms(String askingWord) {
        if (askSynonyms.contains(askingWord)) {
            System.out.println("already");
        }
        else{
            askSynonyms.add(askingWord);
        }
    }
    public static void addIdeas(String Ideas) {
        if (ideas.contains(Ideas)) {
            System.out.println("already");
        }
        else{
            ideas.add(Ideas);
        }
    }

    public void setWebDevelopmentIdeas(String[] webDevelopmentIdeas) {
        dataBase.webDevelopmentIdeas = webDevelopmentIdeas;
    }

    public void setDesktopIdeas(String[] desktopIdeas) {
        dataBase.desktopIdeas = desktopIdeas;
    }

    public void setDatabaseProgrammingIdeas(String[] databaseProgrammingIdeas) {
        dataBase.databaseProgrammingIdeas = databaseProgrammingIdeas;
    }

    public void setMobileIdeas(String[] mobileIdeas) {
        dataBase.mobileIdeas = mobileIdeas;
    }

    public void setAiIdeas(String[] aiIdeas) {
        dataBase.aiIdeas = aiIdeas;
    }
}
