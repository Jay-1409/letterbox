/*
 *
 *  * Copyright (c) 2025-2026 Jay Shah
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.example.letterbox.entity;

import java.util.List;

public record SlugList() {

    public static final List<String> ADJECTIVES = List.of(
            "random", "wonderful", "awesome", "super", "clean", "elegant", "fancy", "glamorous", "handsome", "magnificent",
            "fashionable", "plain", "quaint", "sparkling", "chic", "polished", "sleek", "lavish", "stylish", "attractive",
            "breathtaking", "ritzy", "tasteful", "swanky", "picturesque", "mesmerising", "unique", "aesthetic", "resplendent", "regal",
            "enchanting", "immaculate", "ornate", "opulent", "splendid", "gorgeous", "exotic", "glistening", "friendly", "joyful",
            "delightful", "radiant", "charming", "whimsical", "serene", "lovely", "benevolent", "harmonious", "graceful", "heartwarming",
            "upbeat", "soothing", "tranquil", "captivating", "effervescent", "enjoyable", "cuddly", "sweet", "inviting", "endearing",
            "amiable", "caring", "comforting", "inspiring", "nurturing", "relaxing", "vibrant", "jovial", "celestial"
    );

    public static final List<String> ANIMALS = List.of(
            "lion", "tiger", "elephant", "giraffe", "zebra", "koala", "kangaroo", "cheetah", "lemur", "rhino",
            "hippo", "panda", "jaguar", "lemming", "lynx", "otter", "ocelot", "meerkat", "hyena", "gazelle",
            "mongoose", "sloth", "panther", "bobcat", "dingo", "anteater", "armadillo", "chameleon", "tapir", "platypus",
            "wallaby", "iguana", "orca", "serval", "weasel", "quokka", "badger", "okapi", "mandrill", "pangolin",
            "narwhal", "wombat", "vulture", "porcupine", "aardvark", "chinchilla", "coati", "gecko", "warthog", "impala",
            "elk", "baboon", "buffalo", "puma", "gibbon", "newt", "marmoset", "vicuna", "echidna", "capybara",
            "caribou", "chipmunk", "mantis", "civet", "cormorant", "crocodile", "caiman", "leopard", "dugong", "tarsier",
            "penguin", "ibex", "unicorn", "yak"
    );

    public static final List<String> NOUNS = List.of(
            "jabba", "hyperspace", "apple", "tree", "book", "car", "sun", "moon", "river", "flower", "ocean", "computer",
            "mountain", "house", "chair", "shoe", "cloud", "pen", "robot", "castle", "butterfly", "diamond", "volcano", "island",
            "rain", "sword", "candle", "star", "mirror", "tornado", "key", "guitar", "clock", "hammer", "bottle", "bridge",
            "planet", "feather", "wizard", "mask", "statue", "drum", "breeze", "rocket", "lighthouse", "telescope", "crown", "whisper",
            "thunder", "flute", "sunset", "puzzle", "carousel", "treasure", "quill", "fountain", "circuit", "horizon", "velvet", "cathedral",
            "ballet", "crystal", "harbor", "harmony", "mystic", "stardust", "beacon", "chandelier", "marble", "paradise", "echo", "rainbow",
            "cactus", "cog", "cafe", "piano", "silhouette", "chess", "meditation", "submarine", "legend", "carnival", "umbrella", "infinity",
            "serenity", "compass", "labyrinth", "constellation", "illusion", "galaxy", "cascade", "oracle", "meridian", "reverie", "trinity", "eternity",
            "haven", "dewdrop", "moss", "alchemy", "aria", "cobweb", "solstice", "veranda", "serendipity", "wisdom", "spectrum", "quasar",
            "mirage", "spell", "lacuna", "essence", "crescent", "fragrance", "twilight", "virtue", "equinox", "mystique", "nectar", "elixir",
            "solitude", "gazebo", "opal", "dusk", "candlelight", "monolith", "nova", "plume", "aurora", "paragon", "rhapsody", "arcade",
            "charisma", "comet", "marvel", "boulevard", "caliber", "insight", "fantasy", "symphony", "pinnacle", "lagoon", "sonnet", "sapphire",
            "resonance", "wonder", "voyage", "solar", "phantom", "zenith"
    );

    public static final List<String> COLORS = List.of(
            "red", "orange", "yellow", "green", "blue", "purple", "pink", "brown", "gray", "black", "white", "turquoise",
            "indigo", "teal", "maroon", "emerald", "lavender", "magenta", "amber", "ivory", "ruby", "sapphire", "rose", "coral",
            "gold", "silver", "bronze", "copper", "plum", "vermilion", "cerulean", "crimson", "ebony", "chartreuse", "fuchsia", "violet",
            "olive", "mauve", "periwinkle", "ochre", "taupe", "sepia", "aquamarine", "burgundy", "navy", "khaki", "peach", "lilac",
            "honeydew", "powderblue", "pumpkin", "sienna", "orchid", "thistle", "champagne", "raspberry", "cobalt", "celadon", "garnet", "slate",
            "mulberry", "cinnamon", "lemon", "tangerine", "jade", "caramel", "pear", "mahogany", "lapis", "citrine", "persimmon", "alabaster",
            "amethyst", "wisteria", "glaucous", "papaya", "pansy", "watermelon", "iris", "flaxen", "rufous", "hazelnut", "tangelo", "scarlet",
            "carmine", "linen", "ultraviolet"
    );

    public static final List<String> COSMOS = List.of(
            "tardis", "cosmos", "galaxy", "universe", "stellar", "nebula", "quasar", "supernova", "gravity", "celestial",
            "interstellar", "infinity", "singularity", "multiverse", "astrophysics", "luminous", "constellation", "pulsar", "parallax", "vortex",
            "comet", "spacetime", "gamma", "orbital", "intergalactic", "extraterrestrial", "zenith", "inflation", "void", "hyperspace",
            "quark", "starburst", "cosmonaut", "moonbeam", "antimatter", "horizon", "astronomer", "astrolabe", "stargazer", "redshift"
    );

    public static final List<String> SEASONS = List.of("winter", "spring", "summer", "autumn");

    public static final List<String> VERBS = List.of(
            "run", "jump", "swim", "sing", "dance", "laugh", "think", "dream", "create", "explore", "climb", "read", "write", "paint",
            "draw", "build", "solve", "teach", "learn", "discover", "listen", "speak", "whisper", "shout", "imagine", "play", "work", "relax",
            "travel", "cook", "bake", "sew", "plant", "harvest", "design", "compose", "photograph", "ride", "drive", "fly", "swirl", "twirl",
            "sparkle", "enjoy", "care", "believe", "achieve", "inspire", "encourage", "challenge", "conquer", "transform", "grow", "shine", "awaken",
            "ignite", "whisk", "stitch", "forge", "wander", "navigate", "ascent", "plunge", "sculpt", "illuminate", "assemble", "initiate", "sketch",
            "carve", "illumine", "propel", "effervesce", "imbue", "harmonize", "ruminate", "expound", "invent", "orchestrate", "refine", "adventure",
            "meander", "resonate", "persuade", "inquire", "gaze", "immerse", "endure", "traverse", "revel", "perceive", "treasure", "quench", "enrich", "cultivate"
    );

}