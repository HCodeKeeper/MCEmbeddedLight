
def convert(mc_light):
    coef = 0
    if mc_light/4 >= 1:
        coef = 1

    return int(100/15 * mc_light * coef -(coef-1))