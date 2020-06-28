storyFormat = """Once upon a time, deep in an ancient jungle,
there lived a {animal}. This {animal}
liked to eat {food}, but the jungle had
very little {food} to offer. One day, an
explorer found the {animal} and discovered
it liked {food}. The explorer took the
{animal} back to {city}, where it could
eat as much {food} as it wanted. However,
the {animal} became homesick, so the
explorer brought it back to the jungle,
leaving a large supply of {food}.

The Enl
"""


def add_pick(cue, dictionary):
    prompt = "Enter an example for " + cue + ": "
    response = input(prompt)
    dictionary[cue] = response


def tell_story():
    user_picks = dict() # using a dictionary (inbuilt datastructure)
    add_pick('animal', user_picks)
    add_pick('food', user_picks)
    add_pick('city', user_picks)
    story = storyFormat.format(**user_picks)

    print(story)

tell_story()
input("Press ENTER to stop the program")
