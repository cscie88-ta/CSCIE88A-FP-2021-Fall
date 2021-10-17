import pandas as pd


def do_pandas_simple():
    my_numbers = [1,2,3]
    df = pd.DataFrame(my_numbers)
    print("df = \n{}".format(df))
    # transform numbers using my mapper function
    df_tr_apply = df.apply(my_map_fn)
    print("df_tr_apply = \n{}".format(df_tr_apply))
    # same - using transform()
    df_tr = df.transform(my_map_fn)
    print("df_tr = \n{}".format(df_tr))
    # transform using lambdas
    df_tr_lambdas = df.apply(lambda x: x*2+5)
    print("df_tr_lambdas = \n{}".format(df_tr_lambdas))


def my_map_fn(int_item):
    multiply_by = 2
    add_factor = 5
    try:
        result = int_item * multiply_by + add_factor
        return result
    except Exception as e:
        print("EXCEPTION in my_map_fn(): {}", format(str(e)))


def do_groupby_with_agg():
    animals = [
        ("cat", "Sparky", 5),
        ("dog", "Hero", 10),
        ("dog", "Pirate", 3),
        ("cat", "Lazy", 6),
        ("cat", "Baby", 0.5)
    ]
    df = pd.DataFrame(animals, columns=['Type', 'Name', 'Age'])
    print("df = \n{}".format(df))
    groups_by_type = df.groupby(['Type'])
    print("groups_by_type = \n")
    groups_by_type.apply(print)
    groups_by_type_avg_age = groups_by_type.aggregate("mean")
    print("groups_by_type_avg_age = \n{}".format(groups_by_type_avg_age))


if __name__ == "__main__":
    do_pandas_simple()
    #do_groupby_with_agg()
