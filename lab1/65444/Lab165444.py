import pulp

my_lp_problem = pulp.LpProblem("MyLPProblem", pulp.LpMaximize)

x1 = pulp.LpVariable("x1", 0, None, pulp.LpInteger)
x2 = pulp.LpVariable("x2", 0, None, pulp.LpInteger)
x3 = pulp.LpVariable("x3", 0, None, pulp.LpInteger)
x4 = pulp.LpVariable("x4", 0, None, pulp.LpInteger)

my_lp_problem += 8 * x1 + 4 * x2 + 6 * x3 + 3 * x4, "Z"

my_lp_problem += 12 * x1 + 8 * x2 + 10 * x3 + 5 * x4 <= 1600
my_lp_problem += 11 * x1 + 2 * x2 + 12* x3 + 6 * x4 <= 5000

print(my_lp_problem)

my_lp_problem.solve()
print(pulp.LpStatus[my_lp_problem.status])

for variable in my_lp_problem.variables():
    print(variable.name, variable.varValue)

print(pulp.value(my_lp_problem.objective))