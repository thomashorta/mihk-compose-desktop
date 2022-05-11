package data.source

import data.model.GenericForensicTileModel

class HardcodedDataSource : DataSource {
    override val means = listOf(
        "Alcohol",
        "Amoeba",
        "Arsenic",
        "Arson",
        "Axe",
        "Bamboo Tip",
        "Bat",
        "Belt",
        "Bite And Tear",
        "Blender",
        "Blood Release",
        "Box Cutter",
        "Brick",
        "Bury",
        "Candlestick",
        "Chainsaw",
        "Chemicals",
        "Cleaver",
        "Crutch",
        "Dagger",
        "Dirty Water",
        "Dismember",
        "Drill",
        "Drown",
        "Dumbbell",
        "E-Bike",
        "Electric Baton",
        "Electric Current",
        "Explosives",
        "Folding Chair",
        "Gunpowder",
        "Hammer",
        "Hook",
        "Ice Skates",
        "Illegal Drug",
        "Injection",
        "Kerosene",
        "Kick",
        "Knife And Fork",
        "Lighter",
        "Liquid Drug",
        "Locked Room",
        "Machete",
        "Machine",
        "Mad Dog",
        "Match",
        "Mercury",
        "Metal Chain",
        "Metal Wire",
        "Overdose",
        "Packing Tape",
        "Pesticide",
        "Pill",
        "Pillow",
        "Pistol",
        "Plague",
        "Plastic Bag",
        "Poisonous Gas",
        "Poisonous Needle",
        "Potted Plant",
        "Powder Drug",
        "Punch",
        "Push",
        "Radiation",
        "Razor Blade",
        "Rope",
        "Scarf",
        "Scissors",
        "Sculpture",
        "Smoke",
        "Sniper",
        "Starvation",
        "Steel Tube",
        "Stone",
        "Sulfuric Acid",
        "Surgery",
        "Throat Slit",
        "Towel",
        "Trophy",
        "Trowel",
        "Unarmed",
        "Venomous Scorpion",
        "Venomous Snake",
        "Video Game Console",
        "Virus",
        "Whip",
        "Wine",
        "Wire",
        "Work",
        "Wrench"
    )

    override val clues = listOf(
        "Air Conditioning",
        "Ants",
        "Antique",
        "Apple",
        "Badge",
        "Bandage",
        "Banknote",
        "Bell",
        "Betting Chips",
        "Blood",
        "Bone",
        "Book",
        "Bracelet",
        "Bread",
        "Briefs",
        "Broom",
        "Bullet",
        "Button",
        "Cake",
        "Calender",
        "Candy",
        "Carton",
        "Cassette Tape",
        "Cat",
        "Certificate",
        "Chalk",
        "Cigar",
        "Cigarette Ash",
        "Cigarette Butt",
        "Cleaning Cloth",
        "Cockroach",
        "Coffee",
        "Coins",
        "Comics",
        "Computer",
        "Computer Disk",
        "Computer Mouse",
        "Confidential Letter",
        "Cosmetic Mask",
        "Cotton",
        "Cup",
        "Curtains",
        "Dentures",
        "Diamond",
        "Diary",
        "Dice",
        "Dictionary",
        "Dirt",
        "Documents",
        "Dog Fur",
        "Dust",
        "Earrings",
        "Eggs",
        "Electric Circuit",
        "Envelope",
        "Exam Paper",
        "Express Courier",
        "Fan",
        "Fax",
        "Fiber Optics",
        "Fingernails",
        "Flashlight",
        "Flip-Flop",
        "Flute ",
        "Flyer",
        "Food Ingredients",
        "Gear",
        "Gift",
        "Gloves",
        "Glue",
        "Graffiti",
        "Hair",
        "Hairpin",
        "Handcuffs",
        "Hanger",
        "Hat",
        "Headset",
        "Helmet",
        "Herbal Medicine",
        "High Heel",
        "Hourglass",
        "Ice",
        "ID Card",
        "Ink",
        "Insect",
        "Internet Cable",
        "Invitation Card",
        "IOU Note",
        "Iron",
        "IV Bag",
        "Jacket",
        "Jewelry",
        "Juice",
        "Key",
        "Leaf",
        "Leather Bag",
        "Leather Shoe",
        "Lens",
        "Light Bulb",
        "Lipstick",
        "Lock",
        "Lottery Ticket",
        "Love Letter",
        "Luggage",
        "Lunch Box",
        "Magazine",
        "Mahjong Tiles",
        "Map",
        "Mark",
        "Mask",
        "Maze",
        "Menu",
        "Mirror",
        "Mobile Phone",
        "Model",
        "Mosquito",
        "Mosquito Coil",
        "Nail",
        "Name Card",
        "Necklace",
        "Needle And Thread",
        "Newspaper",
        "Note",
        "Notebook",
        "Numbers",
        "Office Supplies",
        "Oil Painting",
        "Oil Stain",
        "Paint",
        "Panties",
        "Peanut",
        "Perfume",
        "Photograph",
        "Plant",
        "Plastic",
        "Playing Cards",
        "Pocket Watch",
        "Postal Stamp",
        "Powder",
        "Prescription",
        "Puppet",
        "Push Pin",
        "Puzzle",
        "Raincoat",
        "Rat",
        "Receipt",
        "Red Wine",
        "Riddle",
        "Ring",
        "Rose",
        "Rubber Stamp",
        "Sack",
        "Safety Pin",
        "Sand",
        "Sawdust",
        "Seasoning",
        "Signature",
        "Skull",
        "Snacks",
        "Soap",
        "Sock",
        "Soft Drink",
        "Speaker",
        "Specimen",
        "Spider",
        "Spinning Top",
        "Sponge",
        "Spring",
        "Steamed Buns",
        "Stockings",
        "Stuffed Toy",
        "Suit",
        "Sunglasses",
        "Surgical Mask",
        "Surveillance Camera",
        "Switch",
        "Syringe",
        "Table Lamp",
        "Take-Out",
        "Tattoo",
        "Tea Leaves",
        "Telephone",
        "Test Tube",
        "Tie",
        "Timber",
        "Tissue",
        "Tool Box",
        "Toothpicks",
        "Toy",
        "Toy Blocks",
        "Tweezers",
        "Umbrella",
        "Uniform",
        "USB Flash Drive",
        "Vegetables",
        "Video Camera",
        "Violin",
        "Wallet",
        "Watch",
        "Wig"
    )

    override val causeOfDeath = GenericForensicTileModel(
        "Cause of Death",
        listOf(
            "Suffocation",
            "Severe Injury",
            "Loss of Blood",
            "Illness/ Disease",
            "Poisoning",
            "Accident"
        )
    )

    override val locations = listOf(
        GenericForensicTileModel(
            "Location",
            listOf(
                "Living Room",
                "Bedroom",
                "Storeroom",
                "Bathroom",
                "Kitchen",
                "Balcony"
            )
        ),
        GenericForensicTileModel(
            "Location",
            listOf(
                "Vacation Home",
                "Park",
                "Supermarket",
                "School",
                "Woods",
                "Bank"
            )
        ),
        GenericForensicTileModel(
            "Location",
            listOf(
                "Pub",
                "Bookstore",
                "Restaurant",
                "Hotel",
                "Hospital",
                "Building Site"
            )
        ),
        GenericForensicTileModel(
            "Location",
            listOf(
                "Playground",
                "Classroom",
                "Dormitory",
                "Cafeteria",
                "Elevator",
                "Toilet"
            )
        )
    )

    override val sceneDetails = listOf(
        GenericForensicTileModel(
            "Motive of Crime",
            listOf(
                "Hatred",
                "Power",
                "Money",
                "Love",
                "Jealousy",
                "Justice"
            )
        ),
        GenericForensicTileModel(
            "Weather",
            listOf(
                "Sunny",
                "Stormy",
                "Dry",
                "Humid",
                "Cold",
                "Hot"
            )
        ),
        GenericForensicTileModel(
            "Hint on Corpse",
            listOf(
                "Head",
                "Chest",
                "Hand",
                "Leg",
                "Partial",
                "All-over"
            )
        ),
        GenericForensicTileModel(
            "General Impression",
            listOf(
                "Common",
                "Creative",
                "Fishy",
                "Cruel",
                "Horrible",
                "Suspenseful"
            )
        ),
        GenericForensicTileModel(
            "Corpse Condition",
            listOf(
                "Still Warm",
                "Stiff",
                "Decayed",
                "Incomplete",
                "Intact",
                "Twisted"
            )
        ),
        GenericForensicTileModel(
            "Victim's Identity",
            listOf(
                "Child",
                "Young Adult",
                "Middle-Aged",
                "Senior",
                "Male",
                "Female"
            )
        ),
        GenericForensicTileModel(
            "Murderer's Personality",
            listOf(
                "Arrogant",
                "Despicable",
                "Furious",
                "Greedy",
                "Forceful",
                "Perverted"
            )
        ),
        GenericForensicTileModel(
            "State of The Scene",
            listOf(
                "Bits and Pieces",
                "Ashes",
                "Water Stain",
                "Cracked",
                "Disorderly",
                "Tidy"
            )
        ),
        GenericForensicTileModel(
            "Victim's Build",
            listOf(
                "Large",
                "Thin",
                "Tall",
                "Short",
                "Disfigured",
                "Fit"
            )
        ),
        GenericForensicTileModel(
            "Victim's Clothes",
            listOf(
                "Neat",
                "Untidy",
                "Elegant",
                "Shabby",
                "Bizarre",
                "Naked"
            )
        ),
        GenericForensicTileModel(
            "Evidence Left Behind",
            listOf(
                "Natural",
                "Artistic",
                "Written",
                "Synthetic",
                "Personal",
                "Unrelated"
            )
        ),
        GenericForensicTileModel(
            "Victim's Expression",
            listOf(
                "Peaceful",
                "Struggling",
                "Frightened",
                "In Pain",
                "Blank",
                "Angry"
            )
        ),
        GenericForensicTileModel(
            "Time of Death",
            listOf(
                "Dawn",
                "Morning",
                "Noon",
                "Afternoon",
                "Evening",
                "Midnight"
            )
        ),
        GenericForensicTileModel(
            "Duration of Crime",
            listOf(
                "Instantaneous",
                "Brief",
                "Gradual",
                "Prolonged",
                "Few Days",
                "Unclear"
            )
        ),
        GenericForensicTileModel(
            "Trace at the Scene",
            listOf(
                "Fingerprint",
                "Footprint",
                "Bruise",
                "Blood Stain",
                "Body Fluid",
                "Scar"
            )
        ),
        GenericForensicTileModel(
            "Noticed by Bystander",
            listOf(
                "Sudden sound",
                "Prolonged sound",
                "Smell",
                "Visual",
                "Action",
                "Nothing"
            )
        ),
        GenericForensicTileModel(
            "Social Relationship",
            listOf(
                "Relatives",
                "Friends",
                "Colleagues",
                "Employer/ Employee",
                "Lovers",
                "Strangers"
            )
        ),
        GenericForensicTileModel(
            "Victim's Occupation",
            listOf(
                "Boss",
                "Professional",
                "Worker",
                "Student",
                "Unemployed",
                "Retired"
            )
        ),
        GenericForensicTileModel(
            "In Progress",
            listOf(
                "Entertainment",
                "Relaxation",
                "Assembly",
                "Trading",
                "Visit",
                "Dining"
            )
        ),
        GenericForensicTileModel(
            "Sudden Incident",
            listOf(
                "Power Failure",
                "Fire",
                "Conflict",
                "Loss of Valuables",
                "Scream",
                "Nothing"
            )
        ),
        GenericForensicTileModel(
            "Day of Crime",
            listOf(
                "Weekday",
                "Weekend",
                "Spring",
                "Summer",
                "Autumn",
                "Winter"
            )
        ),
    )

    override val events get() = TODO("Not yet implemented")
}
